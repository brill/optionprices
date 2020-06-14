package com.chandan.model;

public class Option {
  private String id;
  private String code;
  private String ticker;
  private String expiration;
  private String strike;
  private String type;


  public Option(String id, String code, String ticker, String expiration, String strike, String type) {
    this.id = id;
    this.code = code;
    this.ticker = ticker;
    this.expiration = expiration;
    this.strike = strike;
    this.type = type;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getTicker() {
    return ticker;
  }

  public void setTicker(String ticker) {
    this.ticker = ticker;
  }

  public String getExpiration() {
    return expiration;
  }

  public void setExpiration(String expiration) {
    this.expiration = expiration;
  }

  public String getStrike() {
    return strike;
  }

  public void setStrike(String strike) {
    this.strike = strike;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}
