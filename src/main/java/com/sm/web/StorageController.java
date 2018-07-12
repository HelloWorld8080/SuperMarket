package com.sm.web;

import com.sm.entity.Storage;
import com.sm.entity.StorageName;
import com.sm.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/store")
public class StorageController {
    @Autowired
    private StorageService storageService;


    @RequestMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("storages", storageService.getAllName());
        return "Storage/list";
    }

    @RequestMapping(value = "/{page}")
    public String addPage(@PathVariable("page") String page) {
        return "Storage/" + page;
    }

    @RequestMapping("/create")
    public String add(Storage storage) {
        storageService.create(storage);
        return "redirect:/store/list";
    }

    @RequestMapping("/edit/{commodityId}")
    public String edit(@PathVariable("commodityId") Integer commodityId, Model model) {
        model.addAttribute("storage", storageService.findOne(commodityId));
        return "Storage/edit";
    }

    @RequestMapping(value = "/search")
    public String sendName(Model model) {

        model.addAttribute("storages", storageService.getEmp());

        return "Storage/search";
    }

    //    @ResponseBody
//    @RequestMapping(value = "/fan",method = RequestMethod.POST)
//    public List<StorageName>test(HttpServletRequest request, Model model){
//        Map<String, String> map = StringToJson.getString(request);
//        model.addAttribute("storages", storageService.getByCon(map));
//        return  storageService.getByCon(map);
//
//    }
    @RequestMapping(value = "/fan", method = RequestMethod.POST)
    public String test(HttpServletRequest request, Model attributes) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("employeeId", (String) request.getParameter("employeeId"));
        map.put("beginDate", (String) request.getParameter("beginDate"));
        map.put("endDate", (String) request.getParameter("endDate"));
        attributes.addAttribute("storages", storageService.getByCon(map));

        return "Storage/list";

    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Storage storage) {
        storageService.update(storage);
        return "redirect:/store/list";

    }
}
