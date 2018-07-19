package com.sm.entity;

import java.io.Serializable;
import java.util.List;

public class Purchild implements Serializable {
    private String purchildId;
    private String purchaseId;
    private String commodityId;
    private String purchasePrice;
    private String supplierId;
    private String purchaseAmount;
    private List<Rechild> rechildren;

    public String getPurchildId() {
        return purchildId;
    }

    public void setPurchildId(String purchildId) {
        this.purchildId = purchildId;
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(String purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    @Override
    public String toString() {
        return "purchase_id :" + purchaseId + " commodity_id: " + commodityId;
    }

    public List<Rechild> getRechildren() {
        return rechildren;
    }

    public void setRechildren(List<Rechild> rechildren) {
        this.rechildren = rechildren;
    }
}
