package com.chandan.model;

import java.util.Map;

public class SortedOptionTypePricesByExpirationDate {
    private String stikePrice;
    Map<String, BidPriceAndDate> sortedCallPricesByDate;
    Map<String, BidPriceAndDate> sortedPutPricesByDate;

    public SortedOptionTypePricesByExpirationDate(String stikePrice, Map<String, BidPriceAndDate> sortedCallPricesByDate, Map<String, BidPriceAndDate> sortedPutPricesByDate) {
        this.stikePrice = stikePrice;
        this.sortedCallPricesByDate = sortedCallPricesByDate;
        this.sortedPutPricesByDate = sortedPutPricesByDate;
    }

    public String getStikePrice() {
        return stikePrice;
    }

    public void setStikePrice(String stikePrice) {
        this.stikePrice = stikePrice;
    }

    public Map<String, BidPriceAndDate> getSortedCallPricesByDate() {
        return sortedCallPricesByDate;
    }

    public void setSortedCallPricesByDate(Map<String, BidPriceAndDate> sortedCallPricesByDate) {
        this.sortedCallPricesByDate = sortedCallPricesByDate;
    }

    public Map<String, BidPriceAndDate> getSortedPutPricesByDate() {
        return sortedPutPricesByDate;
    }

    public void setSortedPutPricesByDate(Map<String, BidPriceAndDate> sortedPutPricesByDate) {
        this.sortedPutPricesByDate = sortedPutPricesByDate;
    }
}
