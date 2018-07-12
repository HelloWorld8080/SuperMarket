package com.sm.web;

import com.sm.entity.RechildAndName;
import com.sm.service.ReceiptService;
import com.sm.Tools.StringToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/rec")
public class ReceiptController {
    @Autowired
    ReceiptService receiptService;

    @ResponseBody
    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public synchronized List<RechildAndName> test(HttpServletRequest request) {
        Map<String, String> map = StringToJson.getString(request);
        for (String name : map.keySet()) {
            System.out.println(map.get(name));
        }
        return receiptService.query(map);
    }

    @RequestMapping(value = "/{page}")
    public String addPage(@PathVariable("page") String page) {
        return "Receipt/" + page;
    }
}
