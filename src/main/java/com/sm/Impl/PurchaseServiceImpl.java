package com.sm.Impl;

import com.sm.dao.EmployeeDao;
import com.sm.dao.PurchaseDao;
import com.sm.dao.PurchildDao;
import com.sm.entity.Commodity;
import com.sm.entity.Employee;
import com.sm.entity.Purchase;
import com.sm.entity.Purchild;
import com.sm.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    private PurchaseDao purchaseDao;
    @Autowired
    private PurchildDao purchildDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public void createPurchase(Purchase purchase) {
        purchaseDao.insert(purchase);
    }

    @Override
    public void createPurchild(Purchild purchild) {
        purchildDao.insert(purchild);
    }

    @Override
    public List<Purchase> queryAll() {
        return purchaseDao.queryAll();
    }

    @Override
    public int isExit(String name) {
        int n = employeeDao.queryByname(name) == null ? 0 : employeeDao.queryByname(name);
        return n;
    }


}
