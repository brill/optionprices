package com.chandan.model;


/*
"date": "2020-06-09",
                "close": "0.05",
                "close_bid": "0.0",
                "close_ask": "0.1",
                "volume": 0,
                "volume_bid": 0,
                "volume_ask": 0,
                "trades": 0,
                "open_interest": 10,
                "open_interest_change": 0,
                "next_day_open_interest": 0,
                "implied_volatility": "1.77549",
                "implied_volatility_change": null,
                "delta": "0.00501"
 */
public class Price {
  private String date;
  private String close;
  private String close_bid;
  private String close_ask;
  private String volume;
  private String volume_bid;
  private String volume_ask;
  private String trades;
  private String open_interest;
  private String open_interest_change;
  private String next_day_open_interest;
  private String implied_volatility;
  private String implied_volatility_change;
  private String delta;

  public Price(String date, String close,
               String close_bid, String close_ask,
               String volume, String volume_bid,
               String volume_ask, String trades,
               String openInterest, String openInterestChange,
               String nextDayOpenInterest, String impliedVolatility,
               String impliedVolatilityChange, String delta) {
    this.date = date;
    this.close = close;
    this.close_bid = close_bid;
    this.close_ask = close_ask;
    this.volume = volume;
    this.volume_bid = volume_bid;
    this.volume_ask = volume_ask;
    this.trades = trades;
    this.open_interest = openInterest;
    this.open_interest_change = openInterestChange;
    this.next_day_open_interest = nextDayOpenInterest;
    this.implied_volatility = impliedVolatility;
    this.implied_volatility_change = impliedVolatilityChange;
    this.delta = delta;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getClose() {
    return close;
  }

  public void setClose(String close) {
    this.close = close;
  }

  public String getClose_bid() {
    return close_bid;
  }

  public void setClose_bid(String close_bid) {
    this.close_bid = close_bid;
  }

  public String getClose_ask() {
    return close_ask;
  }

  public void setClose_ask(String close_ask) {
    this.close_ask = close_ask;
  }

  public String getVolume() {
    return volume;
  }

  public void setVolume(String volume) {
    this.volume = volume;
  }

  public String getVolume_bid() {
    return volume_bid;
  }

  public void setVolume_bid(String volume_bid) {
    this.volume_bid = volume_bid;
  }

  public String getVolume_ask() {
    return volume_ask;
  }

  public void setVolume_ask(String volume_ask) {
    this.volume_ask = volume_ask;
  }

  public String getTrades() {
    return trades;
  }

  public void setTrades(String trades) {
    this.trades = trades;
  }

  public String getOpen_interest() {
    return open_interest;
  }

  public void setOpen_interest(String open_interest) {
    this.open_interest = open_interest;
  }

  public String getOpen_interest_change() {
    return open_interest_change;
  }

  public void setOpen_interest_change(String open_interest_change) {
    this.open_interest_change = open_interest_change;
  }

  public String getNext_day_open_interest() {
    return next_day_open_interest;
  }

  public void setNext_day_open_interest(String next_day_open_interest) {
    this.next_day_open_interest = next_day_open_interest;
  }

  public String getImplied_volatility() {
    return implied_volatility;
  }

  public void setImplied_volatility(String implied_volatility) {
    this.implied_volatility = implied_volatility;
  }

  public String getImplied_volatility_change() {
    return implied_volatility_change;
  }

  public void setImplied_volatility_change(String implied_volatility_change) {
    this.implied_volatility_change = implied_volatility_change;
  }

  public String getDelta() {
    return delta;
  }

  public void setDelta(String delta) {
    this.delta = delta;
  }
}
