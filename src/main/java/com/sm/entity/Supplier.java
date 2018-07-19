package com.sm.entity;

import java.io.Serializable;

public class Supplier implements Serializable {
    private Integer supplierId;
    private String supplierAdd;
    private String supplierName;
    private String supplierTel;
    private String supplierPrincipal;

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierAdd() {
        return supplierAdd;
    }

    public void setSupplierAdd(String supplierAdd) {
        this.supplierAdd = supplierAdd;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierTel() {
        return supplierTel;
    }

    public void setSupplierTel(String supplierTel) {
        this.supplierTel = supplierTel;
    }

    public String getSupplierPrincipal() {
        return supplierPrincipal;
    }

    public void setSupplierPrincipal(String supplierPrincipal) {
        this.supplierPrincipal = supplierPrincipal;
    }
}
