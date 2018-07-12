package com.sm.dao;

import com.sm.entity.OutBound;
import com.sm.entity.OutBoundName;

import java.util.List;
import java.util.Map;

public interface OutBoundDao {
    void create(OutBound OutBound);
    List<OutBound> getAll();
    List<OutBoundName> getAllName();
    OutBound querySingle(int id);
    List<OutBoundName> getBy(Map<String, String> map);
}
