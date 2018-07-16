package com.sm.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm.Component.EmailSender;
import com.sm.entity.Commodity;
import com.sm.entity.NameAndTime;
import com.sm.redis.RedisCache;
import com.sm.service.CommodityService;

import com.sm.service.ReceiptService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.RedisAccessor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RequiresRoles("admin")
@Controller
@RequestMapping(value = "comm")
public class CommodityController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ReceiptService receiptService;
    @Autowired
    CommodityService commodityService;

    @Autowired
    JedisPool jedisPool;

    @Autowired
    JavaMailSender mailSender;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String all(Model model, @RequestParam(value = "id",defaultValue ="1") String id) throws Exception {
        PageHelper.startPage(Integer.valueOf(id), 3);
        List<Commodity> list = commodityService.selectAll();
        PageInfo<Commodity> page = new PageInfo<Commodity>(list);
        model.addAttribute("commodities", page.getList());
//        System.out.println(jedisPool);
////        System.out.println(jedisPool.getResource().get("test"));

        return "Commodity/list";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    public String create(Commodity commodity) {
//        Commodity commodity = new Commodity();
//        commodity.setCommodityName(request.getParameter("commodity_name"));
//        commodity.setCommodityPrice(Double.valueOf(request.getParameter("commodity_price")));
        commodityService.create(commodity);
        return "redirect:/comm/list?id=1";
    }

    @RequestMapping(value = "/edit/{commodityId}")
    public String edit(@PathVariable("commodityId") int commodityId, Model model) {
        model.addAttribute("commodity", commodityService.findById(commodityId));
        return "Commodity/edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(Commodity commodity) {
        System.out.println(commodity);
        commodityService.edit(commodity);
        return "redirect:list?id=1";
    }

    @RequestMapping("/{page}")
    public String Page(@PathVariable("page") String page) {
        return "Commodity/" + page;
    }

    @RequestMapping(value = "/fan", method = RequestMethod.POST)
    public synchronized String test(Model model, HttpServletRequest request) {
        System.out.printf("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        List<NameAndTime> resultList = commodityService.test();
//        Iterator<Map<String, Object>> it = resultList.iterator();
//        while (it.hasNext()){
//            Map<String, Object> temp = it.next();
//            if (temp.size() == 1) it.remove();
//        }
        BufferedReader br;
        StringBuilder sb = null;
        String reqBody = null;
        try {
            br = new BufferedReader(new InputStreamReader(
                    request.getInputStream()));
            String line = null;
            sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            reqBody = URLDecoder.decode(sb.toString(), "UTF-8");
            reqBody = reqBody.substring(reqBody.indexOf("{"));
            request.setAttribute("inputParam", reqBody);
            System.out.println("JsonReq reqBody>>>>>" + reqBody);
            Map<String, String> maps = (Map<String, String>) JSON.parse(reqBody);
//            List<Rechild> rechildList = receiptService.query(maps);
//            for (Rechild rechild: rechildList) {
//                System.out.println(rechild);
//            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.printf(resultList.size() + "");
        model.addAttribute("resultList", resultList);
        return "Commodity/test";
    }

}
