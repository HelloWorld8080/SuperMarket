package com.sm.entity;


public class Receipt {
    private Integer receiptId;
    private String receiptAt;
    private Integer employeeId;
    private Integer receiptDesk;
    private String receiptCost;

    public Integer getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Integer receiptId) {
        this.receiptId = receiptId;
    }

    public String getReceiptAt() {
        return receiptAt;
    }

    public void setReceiptAt(String receiptAt) {
        this.receiptAt = receiptAt;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getReceiptDesk() {
        return receiptDesk;
    }

    public void setReceiptDesk(Integer receiptDesk) {
        this.receiptDesk = receiptDesk;
    }

    public String getReceiptCost() {
        return receiptCost;
    }

    public void setReceiptCost(String receiptCost) {
        this.receiptCost = receiptCost;
    }
}
