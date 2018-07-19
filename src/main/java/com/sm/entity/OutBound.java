package com.sm.entity;

import java.io.Serializable;

public class OutBound implements Serializable {
    private Integer outboundId;
    private Integer commodityId;
    private String outboundAt;
    private Integer employeeId;
    private String outboundAmount;

    public Integer getOutboundId() {
        return outboundId;
    }

    public void setOutboundId(Integer outboundId) {
        this.outboundId = outboundId;
    }

    public Integer getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }

    public String getOutboundAt() {
        return outboundAt;
    }

    public void setOutboundAt(String outboundAt) {
        this.outboundAt = outboundAt;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getOutboundAmount() {
        return outboundAmount;
    }

    public void setOutboundAmount(String outboundAmount) {
        this.outboundAmount = outboundAmount;
    }
}
