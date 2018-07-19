package com.sm.entity;

import java.io.Serializable;

public class Purchase implements Serializable {
    private int purchaseId;
    private String purchaseAt;
    private int employeeId;

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getPurchaseAt() {
        return purchaseAt;
    }

    public void setPurchaseAt(String purchaseAt) {
        this.purchaseAt = purchaseAt;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
