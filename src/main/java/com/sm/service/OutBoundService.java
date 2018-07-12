package com.sm.service;

import com.sm.entity.Employee;
import com.sm.entity.OutBound;
import com.sm.entity.OutBoundName;

import java.util.List;
import java.util.Map;

public interface OutBoundService {
    void create(OutBound outBound);
    List<OutBound> queryAll();
    List<OutBoundName> getAllName();
    OutBound findOne(int id);
    List<Employee> getEmp();
    List<OutBoundName> getByCon(Map<String, String> map);
}
