package com.sm.Impl;

import com.sm.dao.EmployeeDao;
import com.sm.dao.StorageDao;
import com.sm.entity.Employee;
import com.sm.entity.Storage;
import com.sm.entity.StorageName;
import com.sm.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageDao storageDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public void create(Storage storage) {
        storageDao.create(storage);
    }

    @Override
    public List<Storage> queryAll() {
        return storageDao.getAll();
    }

    @Override
    public List<StorageName> getAllName() {
        return storageDao.getAllName();
    }

    @Override
    public Storage findOne(int id) {
        return storageDao.querySingle(id);
    }

    @Override
    public List<Employee> getEmp() {
        return employeeDao.getAll();
    }

    @Override
    public List<StorageName> getByCon(Map<String, String> map) {
        return storageDao.getBy(map);
    }

    @Override
    public void update(Storage storage) {
        storageDao.update(storage);
    }
}
