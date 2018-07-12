package com.sm.entity;

public class NameAndTime {
    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    private String commodityName;
    private String purchaseAt;


    public String getPurchaseAt() {
        return purchaseAt;
    }

    public void setPurchaseAt(String purchaseAt) {
        this.purchaseAt = purchaseAt;
    }
}
