package com.sm.entity;

import java.io.Serializable;

public class RechildAndName implements Serializable {
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

    private String commodityName;

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }
}
