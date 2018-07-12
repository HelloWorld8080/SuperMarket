package com.sm.Impl;

import com.sm.dao.SupplierDao;
import com.sm.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import com.sm.entity.Supplier;

import java.util.List;

@Controller
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao supplierDao;
    @Override
    public void create(Supplier supplier) {
        supplierDao.create(supplier);
    }

    @Override
    public List<Supplier> getAll() {
        return supplierDao.getAll();
    }

    @Override
    public Supplier getSingle(int id) {
        return supplierDao.getSingle(id);
    }

    @Override
    public void update(Supplier supplier) {
         supplierDao.update(supplier);
    }
}
