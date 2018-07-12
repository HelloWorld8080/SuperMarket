package com.sm.Impl;

import com.sm.dao.EmployeeDao;
import com.sm.dao.ReserveDao;
import com.sm.dao.StorageDao;
import com.sm.entity.Employee;
import com.sm.entity.Reserve;
import com.sm.entity.ReserveName;
import com.sm.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

@Controller
public class ReserveServiceImpl implements ReserveService {
    @Autowired
    private ReserveDao ReserveDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private StorageDao storageDao;
    @Override
    public void create(Reserve reserve) {
        ReserveDao.create(reserve);
        storageDao.addAmount(Double.valueOf(reserve.getReserveAmount()), reserve.getCommodityId());

    }

    @Override
    public List<Reserve> queryAll() {
        return ReserveDao.getAll();
    }

    @Override
    public List<ReserveName> getAllName() {
        return ReserveDao.getAllName();
    }

    @Override
    public Reserve findOne(int id) {
        return ReserveDao.querySingle(id);
    }

    @Override
    public List<Employee> getEmp() {
        return employeeDao.getAll();
    }

    @Override
    public List<ReserveName> getByCon(Map<String, String> map) {
        return ReserveDao.getBy(map);
    }


}
