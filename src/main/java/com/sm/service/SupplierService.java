package com.sm.service;


import com.sm.entity.Supplier;

import java.util.List;

public interface SupplierService {
    void create(Supplier supplier);
    List<Supplier> getAll();
    Supplier getSingle(int id);
    void update(Supplier supplier);
}
