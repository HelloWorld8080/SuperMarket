package com.sm.dao;


import com.sm.entity.Commodity;
import com.sm.entity.NameAndTime;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;

public interface CommodityDao {
    List<Commodity> queryAll();
    void insert(Commodity commodity);
    Commodity findSingle(int id);
    void update(Commodity commodity);
    List<NameAndTime> test();
}
