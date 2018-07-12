package com.sm.dao;

import com.sm.entity.Purchase;

import java.util.List;

public interface PurchaseDao {
    List<Purchase> queryAll();
    void insert(Purchase purchase);
}
