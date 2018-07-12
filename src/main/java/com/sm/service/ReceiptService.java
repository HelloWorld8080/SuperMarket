package com.sm.service;

import com.sm.entity.Rechild;
import com.sm.entity.RechildAndName;

import java.util.List;
import java.util.Map;

public interface ReceiptService {
    List<RechildAndName> query(Map<String, String> query);
}
