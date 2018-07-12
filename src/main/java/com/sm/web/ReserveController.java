package com.sm.web;

import com.sm.entity.Reserve;
import com.sm.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/res")
public class ReserveController {
    @Autowired
    private ReserveService reserveService;


    @RequestMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("reserves", reserveService.getAllName());
        model.addAttribute("employees", reserveService.getEmp());

        return "Reserve/list";
    }

    @RequestMapping(value = "/{page}")
    public String addPage(@PathVariable("page") String page) {
        return "Reserve/" + page;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String add(Reserve reserve) {
        reserveService.create(reserve);
        return "redirect:/store/list";
    }
//    @RequestMapping("/edit/{commodityId}" )
//    public String edit(@PathVariable("commodityId") Integer commodityId, Model model) {
//        model.addAttribute("");
//        model.addAttribute("reserve", reserveService.findOne(commodityId));
//        return "Reserve/edit";
//    }
//    @RequestMapping(value = "/search")
//    public String sendName(Model model){
//
//
//        return "Reserve/search";
//    }

    //    @ResponseBody
//    @RequestMapping(value = "/fan",method = RequestMethod.POST)
//    public List<ReserveName>test(HttpServletRequest request, Model model){
//        Map<String, String> map = StringToJson.getString(request);
//        model.addAttribute("reserves", reserveService.getByCon(map));
//        return  reserveService.getByCon(map);
//
//    }
    @RequestMapping(value = "/fan", method = RequestMethod.POST)
    public String test(HttpServletRequest request, Model attributes) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("employeeId", (String) request.getParameter("employeeId"));
        map.put("beginDate", (String) request.getParameter("beginDate"));
        map.put("endDate", (String) request.getParameter("endDate"));
        attributes.addAttribute("reserves", reserveService.getByCon(map));

        return "Reserve/list";

    }
}
