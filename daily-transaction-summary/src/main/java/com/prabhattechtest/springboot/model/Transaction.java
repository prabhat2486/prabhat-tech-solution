package com.prabhattechtest.springboot.model;

public class Transaction {

    private long quantityLong;

    private long quantityShort;

    private String signQuantityLong;

    private String signQuantityShort;

    private long netTransactionAmount;

    public Transaction(String quantityLong, String quantityShort, String signQuantityLong, String signQuantityShort) {
        this.signQuantityLong = signQuantityLong;
        this.signQuantityShort = signQuantityShort;
        this.quantityLong = signQuantityLong.equals("-") ? (-1)*Long.parseLong(quantityLong) : Long.parseLong(quantityLong);
        this.quantityShort = signQuantityShort.equals("-") ? (-1)*Long.parseLong(quantityShort) : Long.parseLong(quantityShort);
        this.setNetTransactionAmount(this.quantityLong - this.quantityShort);
    }


    public long getQuantityLong() {
        return quantityLong;
    }

    public void setQuantityLong(long quantityLong) {
        this.quantityLong = quantityLong;
    }

    public long getQuantityShort() {
        return quantityShort;
    }

    public void setQuantityShort(long quantityShort) {
        this.quantityShort = quantityShort;
    }

    public String getSignQuantityLong() {
        return signQuantityLong;
    }

    public void setSignQuantityLong(String signQuantityLong) {
        this.signQuantityLong = signQuantityLong;
    }

    public String getSignQuantityShort() {
        return signQuantityShort;
    }

    public long getNetTransactionAmount() {
        return netTransactionAmount;
    }

    public void setNetTransactionAmount(long netTransactionAmount) {
        this.netTransactionAmount = netTransactionAmount;
    }

    @Override
    public String toString() {
        return String.valueOf(netTransactionAmount);
    }
}
