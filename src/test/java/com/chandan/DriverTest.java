package com.chandan;

import com.chandan.model.Chain;
import com.chandan.model.OptionChain;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

public class DriverTest {

    @Test
    public void testGetDate()throws Exception{
        String date = "2020-06-19";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d = sdf1.parse(date);
        Date d2 = Driver.getDate(date);
        System.out.println(d);
        System.out.println(d2);
    }

    @Test
    public void testGetDateString() throws Exception{
      String dateString = "Fri Jun 26 00:00:00 PDT 2020";
      Date d = Calendar.getInstance().getTime();
      System.out.println(d);
      SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
      String strDate = formatter.format(d);
      System.out.println("Date Format with MM-dd-yyyy : "+strDate);

    }

    @Test
    public void testFilePath() throws Exception{
      Map<String, List<Chain>> optionChainMap = new HashMap<>();
      List<String> filePaths = Driver.readExpirationDatesFromFile("src/main/resources/prices/2020-06-09");
      for(String expirationDate: filePaths){
        List<Chain> optionChain = Driver.getOptionChain(expirationDate);
        if (optionChain != null) {
          optionChainMap.put(expirationDate, optionChain);
        }
      }
      for(String key: optionChainMap.keySet()){
        List<Chain> chains = optionChainMap.get(key);
        for(Chain chain: chains){
          System.out.println(chain.getOption().getExpiration()+ " "+chain.getOption().getType()+" "+chain.getOption().getStrike() + " "+chain.getPrice().getClose());
        }
      }
      //System.out.println(optionChainMap.keySet().toString());
    }
}
