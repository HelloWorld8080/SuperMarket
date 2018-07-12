package com.sm.service;

import com.sm.entity.Purchase;
import com.sm.entity.Purchild;

import java.util.List;

public interface PurchaseService {
    void createPurchase(Purchase purchase);
    void createPurchild(Purchild purchild);
    List<Purchase> queryAll();
    int isExit(String name);
}
