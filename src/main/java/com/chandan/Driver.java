package com.chandan;

import com.chandan.model.*;
import com.chandan.util.OptionChainReader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Driver {


    public static List<String> readExpirationDatesFromFile(String filePath) {
        File f = new File(filePath);
        List<String> stockFilePaths = new ArrayList<String>();
        List<String> expirationDates = new ArrayList<>();

        String[] listOfFiles = f.list();
        for (String fileName : listOfFiles) {
            stockFilePaths.add(filePath + "/" + fileName);
        }
        for (String stockFileName : stockFilePaths) {
            File fi = new File(stockFileName);
            String[] expirationFiles = fi.list();
            for (String expirationFile : expirationFiles) {
                expirationDates.add(stockFileName + "/" + expirationFile);
            }
        }
        return expirationDates;
    }

    public static Date getDate(String dateString) throws Exception {
        SimpleDateFormat sdateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdateFormat.parse(dateString);
        return d;
    }

    public static String getDateString(Date d) {
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        String strDate = formatter.format(d);
        return strDate;
    }

    public static void main(String[] args) {

        Map<String, List<Chain>> optionChainMap = new HashMap<>();
        List<String> expirationDates = readExpirationDatesFromFile("src/main/resources/prices/2020-06-09");
        for (String expirationDate : expirationDates) {
            List<Chain> optionChain = getOptionChain(expirationDate);
            if (optionChain != null) {
                optionChainMap.put(expirationDate, optionChain);
            }
        }
        Map<String, List<StrikeBidPriceByExpirationDate>> strikeBidPriceByExpirationDateMap = getStrikePriceForStock("MSFT", optionChainMap);
        List<String> strikePrices = new ArrayList<>();
        for (String str : strikeBidPriceByExpirationDateMap.keySet()) {
            strikePrices.add(str);
        }
        Map<String, SortedOptionTypePricesByExpirationDate> optionBidsAndStrikePriceMap = new HashMap<>();
        for (String sp : strikePrices) {
            Map<String, BidPriceAndDate> sortedCallPricesByDate = getBidsByOptionTypeForStrikePrice("call", sp, strikeBidPriceByExpirationDateMap);
            Map<String, BidPriceAndDate> sortedPutPricesByDate = getBidsByOptionTypeForStrikePrice("put", sp, strikeBidPriceByExpirationDateMap);
            optionBidsAndStrikePriceMap.put(sp, new SortedOptionTypePricesByExpirationDate(sp, sortedCallPricesByDate, sortedPutPricesByDate));
        }
        for (String str : optionBidsAndStrikePriceMap.keySet()) {
            Map<String, BidPriceAndDate> sortedCallPricesByDate = optionBidsAndStrikePriceMap.get(str).getSortedCallPricesByDate();
            Map<String, BidPriceAndDate> sortedPutPricesByDate = optionBidsAndStrikePriceMap.get(str).getSortedPutPricesByDate();
            System.out.println("Strikprice: "+str);
            for (String sp : sortedCallPricesByDate.keySet()) {
                System.out.printf("%s %s", sp, sortedCallPricesByDate.get(sp).getBidPrice());
                System.out.println();
            }
            System.out.println("--------");
            for (String sp : sortedPutPricesByDate.keySet()) {
                System.out.printf("%s %s", sp, sortedPutPricesByDate.get(sp).getBidPrice());
                System.out.println();
            }
            System.out.println("****************");
        }
    }

    public static Map<String, BidPriceAndDate> getBidsByOptionTypeForStrikePrice(String optionType, String price, Map<String, List<StrikeBidPriceByExpirationDate>> strikeBidPriceByExpirationDateMap) {
        Map<String, BidPriceAndDate> sortedCallPrices = new HashMap<>();
        for (String sp : strikeBidPriceByExpirationDateMap.keySet()) {
            if (sp.equals(price)) {
                List<StrikeBidPriceByExpirationDate> bidPrices = strikeBidPriceByExpirationDateMap.get(sp);
                Collections.sort(bidPrices);
                for (StrikeBidPriceByExpirationDate bidPrice : bidPrices) {
                    if (bidPrice.getType().equals(optionType)) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(bidPrice.getExpirationDate());
                        String dateString = getDateString(bidPrice.getExpirationDate());
                        sortedCallPrices.put(dateString, new BidPriceAndDate(bidPrice.getBidPrice(), bidPrice.getType(), bidPrice.getExpirationDate()));
                    }
                }
            }
        }
        return sortedCallPrices;
    }

    public static Map<String, List<StrikeBidPriceByExpirationDate>> getStrikePriceForStock(String stock, Map<String, List<Chain>> optionChainMap) {
        Map<String, List<StrikeBidPriceByExpirationDate>> strikeBidPriceByExpirationDateMap = new HashMap<>();
        for (String key : optionChainMap.keySet()) {
            if (key.contains(stock)) {
                List<Chain> chains = optionChainMap.get(key);
                for (Chain chain : chains) {
                    String sp = chain.getOption().getStrike();
                    String bid = chain.getPrice().getClose();
                    String type = chain.getOption().getType();
                    String expirationDate = key.split("/")[6];
                    expirationDate = expirationDate.split("\\.")[0];
                    Date d = null;
                    try {
                        d = getDate(expirationDate);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    if (strikeBidPriceByExpirationDateMap.containsKey(sp)) {
                        List<StrikeBidPriceByExpirationDate> bidList = strikeBidPriceByExpirationDateMap.get(sp);
                        bidList.add(new StrikeBidPriceByExpirationDate(sp, bid, type, d));
                        strikeBidPriceByExpirationDateMap.put(sp, bidList);
                    } else {
                        List<StrikeBidPriceByExpirationDate> bidList = new ArrayList<>();
                        bidList.add(new StrikeBidPriceByExpirationDate(sp, bid, type, d));
                        strikeBidPriceByExpirationDateMap.put(sp, bidList);
                    }
                }
            }
        }
        return strikeBidPriceByExpirationDateMap;
    }

    public static List<Chain> getOptionChain(String fileName) {
        OptionChain optionChain = null;
        String expirationDate = fileName;
        List<Chain> chainList = null;
        OptionChainReader reader = new OptionChainReader();
        try {
            optionChain = reader.getOptionChainFromFile(expirationDate);
            Chain[] chains = optionChain.getChains();
            chainList = Arrays.asList(chains);
        } catch (IOException io) {
            io.printStackTrace();
        }
        return chainList;
    }

}
