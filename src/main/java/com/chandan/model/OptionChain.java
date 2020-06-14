package com.chandan.model;

import java.util.List;
public class OptionChain {
  private Chain[] chain;

  public OptionChain(Chain[] chain) {
    this.chain = chain;
  }

  public Chain[] getChains() {
    return chain;
  }

  public void setChains(Chain[] chains) {
    this.chain = chains;
  }
}
