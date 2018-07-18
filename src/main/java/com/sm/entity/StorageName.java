package com.sm.entity;

import java.io.Serializable;

public class StorageName extends Storage implements Serializable {
    private String commodityName;
    private String employeeName;



    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
}
