package com.sm.service;

import com.sm.dao.CommodityDao;
import com.sm.entity.Commodity;
import com.sm.entity.NameAndTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface CommodityService {
    List<Commodity> selectAll();
    void create(Commodity commodity);
    Commodity findById(int id);
    void edit(Commodity commodity);
    List<NameAndTime> test();
}
