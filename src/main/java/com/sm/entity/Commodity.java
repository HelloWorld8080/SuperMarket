package com.sm.entity;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Date;

public class Commodity implements Serializable {
    private int commodityId;
    private String commodityName;
    private String commodityPrice;

    public String getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(String isDiscount) {
        this.isDiscount = isDiscount;
    }

    private String isDiscount ;
    private String discountStartAt ;
    private String discountEndAt;
    private int commodityBarCode;
    public Commodity() {

    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityPrice() {
        return commodityPrice;
    }

    public void setCommodityPrice(String commodityPrice) {
        this.commodityPrice = commodityPrice;
    }



    public String getDiscountStartAt() {
        return discountStartAt;
    }

    public void setDiscountStartAt(String discountStartAt) {
        this.discountStartAt = discountStartAt;
    }

    public String getDiscountEndAt() {
        return discountEndAt;
    }

    public void setDiscountEndAt(String discountEndAt) {
        this.discountEndAt = discountEndAt;
    }

    public int getCommodityBarCode() {
        return commodityBarCode;
    }

    public void setCommodityBarCode(int commodityBarCode) {
        this.commodityBarCode = commodityBarCode;
    }

    @Override
    public String toString() {
        return "commodity_id : "+ commodityId + " commodity_name : " + commodityName;
    }
}
