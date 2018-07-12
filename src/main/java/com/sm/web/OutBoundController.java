package com.sm.web;

import com.sm.entity.OutBound;
import com.sm.service.OutBoundService;
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
@RequestMapping("/out" +
        "")
public class OutBoundController {
    @Autowired
    private OutBoundService outboundService;


    @RequestMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("outbounds", outboundService.getAllName());
        model.addAttribute("employees", outboundService.getEmp());

        return "OutBound/list";
    }

    @RequestMapping(value = "/{page}")
    public String addPage(@PathVariable("page") String page) {
        return "OutBound/" + page;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String add(OutBound outbound) {
        outboundService.create(outbound);
        return "redirect:/store/list";
    }
//    @RequestMapping("/edit/{commodityId}" )
//    public String edit(@PathVariable("commodityId") Integer commodityId, Model model) {
//        model.addAttribute("");
//        model.addAttribute("outbound", outboundService.findOne(commodityId));
//        return "OutBound/edit";
//    }
//    @RequestMapping(value = "/search")
//    public String sendName(Model model){
//
//
//        return "OutBound/search";
//    }

    //    @ResponseBody
//    @RequestMapping(value = "/fan",method = RequestMethod.POST)
//    public List<OutBoundName>test(HttpServletRequest request, Model model){
//        Map<String, String> map = StringToJson.getString(request);
//        model.addAttribute("outbounds", outboundService.getByCon(map));
//        return  outboundService.getByCon(map);
//
//    }
    @RequestMapping(value = "/fan", method = RequestMethod.POST)
    public String test(HttpServletRequest request, Model attributes) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("employeeId", (String) request.getParameter("employeeId"));
        map.put("beginDate", (String) request.getParameter("beginDate"));
        map.put("endDate", (String) request.getParameter("endDate"));
        attributes.addAttribute("outbounds", outboundService.getByCon(map));

        return "OutBound/list";

    }
}
