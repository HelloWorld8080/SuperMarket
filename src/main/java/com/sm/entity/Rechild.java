package com.sm.entity;

public class Rechild {
    private Integer rechildId;
    private Integer receiptId;
    private Integer commodityId;
    private String receiptAmount;
    private String receiptPrice;
    private String receiptDiscount;

    public Integer getRechildId() {
        return rechildId;
    }

    public void setRechildId(Integer rechildId) {
        this.rechildId = rechildId;
    }

    public Integer getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Integer receiptId) {
        this.receiptId = receiptId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(String receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getReceiptPrice() {
        return receiptPrice;
    }

    public void setReceiptPrice(String receiptPrice) {
        this.receiptPrice = receiptPrice;
    }

    public String getReceiptDiscount() {
        return receiptDiscount;
    }

    public void setReceiptDiscount(String receiptDiscount) {
        this.receiptDiscount = receiptDiscount;
    }

    public String getReceiptExpense() {
        return receiptExpense;
    }

    public void setReceiptExpense(String receiptExpense) {
        this.receiptExpense = receiptExpense;
    }

    private String receiptExpense;

    @Override
    public String toString() {
        return "rechild_id : " + rechildId + " receipt_id : " + receiptId + " commodity_id : " + commodityId
        + " receipt_price : " + receiptPrice + " receipt_amount : " + receiptAmount + " receipt_discount : " + receiptDiscount
        + " receipt_expense : " + receiptExpense;
    }
}
