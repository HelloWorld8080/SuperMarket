package com.sm.Impl;

import com.sm.dao.CommodityDao;
import com.sm.entity.Commodity;
import com.sm.entity.NameAndTime;
import com.sm.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {
    @Autowired
    private CommodityDao commodityDao;

    @Autowired
    public List<Commodity> selectAll() {
        return commodityDao.queryAll();
    }

    public void create(Commodity commodity) {
        commodityDao.insert(commodity);
    }

    @Override
    public Commodity findById(int id) {
        return commodityDao.findSingle(id);
    }

    @Override
    public void edit(Commodity commodity) {
        commodityDao.update(commodity);
    }

    @Override
    public List<NameAndTime> test() {
        return commodityDao.test();
    }



}
