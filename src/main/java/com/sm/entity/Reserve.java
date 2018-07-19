package com.sm.entity;

import java.io.Serializable;

public class Reserve implements Serializable {
    private Integer reserveId;
    private Integer commodityId;
    private String reserveAt;
    private Integer employeeId;
    private String reserveAmount;

    public Integer getReserveId() {
        return reserveId;
    }

    public void setReserveId(Integer reserveId) {
        this.reserveId = reserveId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getReserveAt() {
        return reserveAt;
    }

    public void setReserveAt(String reserveAt) {
        this.reserveAt = reserveAt;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getReserveAmount() {
        return reserveAmount;
    }

    public void setReserveAmount(String reserveAmount) {
        this.reserveAmount = reserveAmount;
    }
}
