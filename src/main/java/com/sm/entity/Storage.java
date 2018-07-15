package com.sm.entity;

import java.io.Serializable;

public class Storage implements Serializable {
    private Integer commodityId;
    private String storageAmount;
    private String storageCheckAt;
    private Integer employeeId;
    private String storageAlert;

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getStorageAmount() {
        return storageAmount;
    }

    public void setStorageAmount(String storageAmount) {
        this.storageAmount = storageAmount;
    }

    public String getStorageCheckAt() {
        return storageCheckAt;
    }

    public void setStorageCheckAt(String storageCheckAt) {
        this.storageCheckAt = storageCheckAt;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getStorageAlert() {
        return storageAlert;
    }

    public void setStorageAlert(String storageAlert) {
        this.storageAlert = storageAlert;
    }
}
