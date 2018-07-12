package com.sm.web;

import com.sm.entity.Supplier;
import com.sm.service.SupplierService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;


@Controller
@RequestMapping("/sup")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @RequestMapping("/{page}")
    public String Page(@PathVariable("page") String page) {
        return "Supplier/" + page;
    }

    @RequestMapping("/create")
    public String add(Supplier supplier) {
        supplierService.create(supplier);
        return "Supplier/add";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("suppliers", supplierService.getAll());
        return "Supplier/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("supplier", supplierService.getSingle(id));
        return "Supplier/edit";
    }

    @RequestMapping("/update")
    public String update(Supplier supplier) {
        supplierService.update(supplier);
        return "redirect:" +
                "/sup/list";
    }
}
