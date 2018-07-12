package com.sm.service;

import com.sm.entity.Employee;
import com.sm.entity.Storage;
import com.sm.entity.StorageName;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public interface StorageService {
    void create(Storage storage);
    List<Storage> queryAll();
    List<StorageName> getAllName();
    Storage findOne(int id);
    List<Employee> getEmp();
    List<StorageName> getByCon(Map<String, String> map);
    void update(Storage storage);
}
