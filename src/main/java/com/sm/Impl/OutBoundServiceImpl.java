package com.sm.Impl;

import com.sm.dao.EmployeeDao;
import com.sm.dao.OutBoundDao;
import com.sm.dao.StorageDao;
import com.sm.entity.Employee;
import com.sm.entity.OutBound;
import com.sm.entity.OutBoundName;
import com.sm.service.OutBoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class OutBoundServiceImpl implements OutBoundService {
    @Autowired
    private OutBoundDao OutBoundDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private StorageDao storageDao;
    @Override
    public void create(OutBound outBound) {
        OutBoundDao.create(outBound);
        storageDao.cutAmount(Double.valueOf(outBound.getOutboundAmount()), outBound.getCommodityId());

    }

    @Override
    public List<OutBound> queryAll() {
        return OutBoundDao.getAll();
    }

    @Override
    public List<OutBoundName> getAllName() {
        return OutBoundDao.getAllName();
    }

    @Override
    public OutBound findOne(int id) {
        return OutBoundDao.querySingle(id);
    }

    @Override
    public List<Employee> getEmp() {
        return employeeDao.getAll();
    }

    @Override
    public List<OutBoundName> getByCon(Map<String, String> map) {
        return OutBoundDao.getBy(map);
    }


}
