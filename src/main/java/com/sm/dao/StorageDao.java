package com.sm.dao;

import com.sm.entity.Storage;
import com.sm.entity.StorageName;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

public interface StorageDao {
    void create(Storage storage);
    List<Storage> getAll();
    List<StorageName> getAllName();
    Storage querySingle(int id);
    List<StorageName> getBy(Map<String, String> map);
    void update(Storage storage);
    void addAmount(@Param("amount") double amount, @Param("id") int id);
    void cutAmount(@Param("amount") double amount, @Param("id") int id);
}
