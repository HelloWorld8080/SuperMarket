package com.sm.dao;

import com.sm.entity.Reserve;
import com.sm.entity.ReserveName;

import java.util.List;
import java.util.Map;

public interface ReserveDao {
    void create(Reserve Reserve);
    List<Reserve> getAll();
    List<ReserveName> getAllName();
    Reserve querySingle(int id);
    List<ReserveName> getBy(Map<String, String> map);
}
