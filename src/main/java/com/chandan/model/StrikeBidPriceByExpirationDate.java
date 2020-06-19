package com.chandan.model;

import java.util.Date;

public class StrikeBidPriceByExpirationDate implements Comparable<StrikeBidPriceByExpirationDate> {
    private String strikePrice;
    private String bidPrice;
    private Date expirationDate;
    private String type;

    public StrikeBidPriceByExpirationDate(String strikePrice, String bidPrice, String type, Date expirationDate) {
        this.strikePrice = strikePrice;
        this.bidPrice = bidPrice;
        this.expirationDate = expirationDate;
        this.type = type;
    }

    public String getStrikePrice() {
        return strikePrice;
    }

    public void setStrikePrice(String strikePrice) {
        this.strikePrice = strikePrice;
    }

    public String getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "StrikeBidPriceByExpirationDate{" +
                "strikePrice='" + strikePrice + '\'' +
                ", bidPrice='" + bidPrice + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }


    @Override
    public int compareTo(StrikeBidPriceByExpirationDate o) {
        if (expirationDate.compareTo(o.expirationDate) < 0)
            return -1;
        return 1;
    }
}
