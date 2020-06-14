package com.chandan;

import com.chandan.model.Chain;
import com.chandan.model.OptionChain;
import com.chandan.util.OptionChainReader;

import java.io.IOException;
import java.util.*;


public class Driver {

  public static void main(String[] args) {

    Map<String, List<Chain>> optionChainMap = new HashMap<>();
    List<String> expirationDates = new ArrayList<>();

    for (String expirationDate : expirationDates) {
      List<Chain> optionChain = getOptionChain(expirationDate);
      if (optionChain != null) {
        optionChainMap.put(expirationDate, optionChain);
      }
    }
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
