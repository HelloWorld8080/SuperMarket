package com.sm.web;

import com.sm.Tools.ExcelUtils;
import com.sm.entity.Commodity;
import com.sm.entity.Purchase;
import com.sm.entity.Purchild;
import com.sm.service.CommodityService;
import com.sm.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping(value = "/pur")
public class PurchaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PurchaseService purchaseService;

    @Autowired
    private CommodityService commodityService;

    @RequestMapping(value = "/createPurchase", method = RequestMethod.POST)
    private String create(Purchase purchase, Model model) {
        if (purchase.getEmployeeId() == 0) {
            model.addAttribute("msg", "Wrong");
            return "Purchase/add";
        } else {
            purchaseService.createPurchase(purchase);
            return "redirect:add";
        }
    }

    @RequestMapping(value = "/addzz/{id}")
    private String add(@PathVariable("id") int id, Model model) {
        model.addAttribute("purchaseId", id);
        return "Purchase/addChild";
    }

    @ResponseBody
    @RequestMapping(value = "/addChild", method = RequestMethod.POST)
    private String createChild(@RequestBody List<Purchild> purChildren) {
        for (Purchild purchild : purChildren) {
            purchaseService.createPurchild(purchild);
        }
        return "redirect:/pur/list";
    }

    @RequestMapping(value = "/addChildren", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
    private String createChild(Purchild purchild) {
        System.out.println(purchild.getPurchildId());
        System.out.println(purchild.getPurchaseAmount());
        purchaseService.createPurchild(purchild);

        return "rediect:/pur/list";
    }

    @RequestMapping(value = "/list")
    private String list(Model model) {
        model.addAttribute("purchases", purchaseService.queryAll());
        return "Purchase/list";
    }

    @RequestMapping(value = "/valid")
    @ResponseBody
    private String valid(String name, Model model) {
        return purchaseService.isExit(name) + "";

    }

    @RequestMapping(value = "/{page}")
    private String addPage(@PathVariable("page") String page) {
        System.out.println("zzzz");
        return "Purchase/" + page;
    }

    @RequestMapping(value = "/uploade", method = RequestMethod.POST)
    @ResponseBody
    public String uplode(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws IOException {
        String path = "";
        if (!file.isEmpty()) {
            //生成uuid作为文件名称
            //String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件类型（可以判断如果不是图片，禁止上传）
           // String contentType = file.getContentType();
            //获得文件后缀名称
          //  String imageName = contentType.substring(contentType.indexOf("/") + 1);
            path = "C:\\Users\\11291\\SuperMarket\\src\\main\\webapp\\Excel\\" + "commodity" + "." + "xlsx";
            file.transferTo(new File(path));
        }
        File file1 =new File(path);
        Commodity commodity = new Commodity();
        List<Commodity> list = ExcelUtils.readExcel(file1, commodity);
        for (Commodity c : list) {
            commodityService.create(c);
        }
        return "";
    }
}
