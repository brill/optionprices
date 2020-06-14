package com.chandan.model;


import java.util.List;
public class Chain {

  private Option option;
  private Price price;

  public Chain(){}

  public Chain(Option option, Price price) {
    this.option = option;
    this.price = price;
  }

  public Option getOption() {
    return option;
  }

  public void setOption(Option option) {
    this.option = option;
  }

  public Price getPrice() {
    return price;
  }

  public void setPrice(Price price) {
    this.price = price;
  }
}
