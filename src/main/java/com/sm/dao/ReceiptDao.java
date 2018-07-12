package com.sm.dao;

import com.sm.entity.Receipt;
import com.sm.entity.Rechild;
import com.sm.entity.RechildAndName;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ReceiptDao {
    List<RechildAndName> query(Map<String, String> query);
}
