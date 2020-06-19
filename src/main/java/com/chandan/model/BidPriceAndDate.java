package com.chandan.model;

import java.util.Date;

public class BidPriceAndDate implements Comparable<BidPriceAndDate> {
    private String bidPrice;
    private String bidType;
    private Date expirationDate;

    public BidPriceAndDate(String bidPrice, String bidType, Date date) {
        this.bidPrice = bidPrice;
        this.bidType = bidType;
        this.expirationDate = date;
    }

    public String getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getBidType() {
        return bidType;
    }

    public void setBidType(String bidType) {
        this.bidType = bidType;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "BidPriceAndDate{" +
                "bidPrice='" + bidPrice + '\'' +
                ", bidType='" + bidType + '\'' +
                ", date=" + expirationDate +
                '}';
    }

    @Override
    public int compareTo(BidPriceAndDate o) {
        if(expirationDate.compareTo(o.expirationDate) < 0)
            return -1;
        return 1;
    }
}
