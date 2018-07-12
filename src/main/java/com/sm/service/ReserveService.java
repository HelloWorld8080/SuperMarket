package com.sm.service;

import com.sm.entity.Employee;
import com.sm.entity.Reserve;
import com.sm.entity.ReserveName;

import java.util.List;
import java.util.Map;

public interface ReserveService {
    void create(Reserve Reserve);
    List<Reserve> queryAll();
    List<ReserveName> getAllName();
    Reserve findOne(int id);
    List<Employee> getEmp();
    List<ReserveName> getByCon(Map<String, String> map);
}
