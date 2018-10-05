package com.linhcr.poly.bookmanager.model;

public class Bill {
    public String billId;
    public long date ;

    public Bill(String billId, long date) {
        this.billId = billId;
        this.date = date;
    }

    public Bill() {

    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public float getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }
}
