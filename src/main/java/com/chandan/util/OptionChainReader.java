package com.chandan.util;

import com.chandan.model.Chain;
import com.chandan.model.OptionChain;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OptionChainReader {


  public OptionChain getOptionChainFromFile(String fileName) throws IOException{
    OptionChain optionChain = readJsonFromFile(fileName);
    return optionChain;
  }

  private OptionChain readJsonFromFile(String fileName) throws IOException {
    BufferedReader breader = new BufferedReader(new FileReader(fileName));
    Gson gson = new Gson();
    OptionChain options = new Gson().fromJson(breader, OptionChain.class);
    return options;
  }
}
