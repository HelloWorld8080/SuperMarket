package com.sm.dao;

import com.sm.entity.Supplier;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;


public interface SupplierDao {
    @Insert("insert into sm_supplier(supplier_name, supplier_add, supplier_tel, supplier_principal) values" +
            "(#{supplierName}, #{supplierAdd}, #{supplierTel}, #{supplierPrincipal" +
            "} )")
    void create(Supplier supplier);

    @Select("select * from sm_supplier")
    List<Supplier> getAll();

    @Select("select * from sm_supplier where supplier_id = #{supplierId}")
    Supplier getSingle(int supplierId);

    @Update("update sm_supplier set supplier_name = #{supplierName}, supplier_add = #{supplierAdd}, supplier_tel" +
            "= #{supplierTel}, supplier_principal = #{supplierPrincipal} where supplier_id = #{supplierId}")
    void update(Supplier supplier);
}
