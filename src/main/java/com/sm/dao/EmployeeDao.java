package com.sm.dao;

import com.sm.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    Integer queryByname(String name);
    List<Employee> getAll();
}
