package com.sm.Impl;

import com.sm.dao.ReceiptDao;
import com.sm.entity.RechildAndName;
import com.sm.service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

@Controller
public class ReceiptServiceImpl implements ReceiptService {
    @Autowired
    ReceiptDao receiptDao;
    @Override
    public List<RechildAndName> query(Map<String, String> query) {
        return receiptDao.query(query);
    }
}
