package com.sm.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sm.Component.EmailSender;
import com.sm.Tools.ExcelUtils;
import com.sm.entity.Commodity;
import com.sm.entity.NameAndTime;
import com.sm.redis.RedisCache;
import com.sm.service.CommodityService;

import com.sm.service.ReceiptService;
import com.sun.deploy.net.HttpResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.core.RedisAccessor;
import org.springframework.http.HttpRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

@RequiresRoles("admin")
@Controller
@RequestMapping(value = "comm")
public class CommodityController {
    private final static String EXCEL_XLS = "xls";
    private final static String EXCEL_XLSX = "xlsx";
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
    public String all(Model model, @RequestParam(value = "id",defaultValue ="1") int id) throws Exception {
//        PageHelper.startPage(Integer.valueOf(id), 3);
//        List<Commodity> list = commodityService.selectAll();
//        PageInfo<Commodity> page = new PageInfo<Commodity>(list);
        PageInfo<Commodity> page = PageHelper.startPage(id, 3).doSelectPageInfo(() -> commodityService.selectAll());
        model.addAttribute("commodities", page.getList());
//        System.out.println(jedisPool);
////        System.out.println(jedisPool.getResource().get("test"));

        productExcel();
        System.out.println("数据导出成功");


        return "Commodity/list";
    }

    public void productExcel() {

        List<Commodity> list = commodityService.selectAll();

        File base = new File("C:\\Users\\11291\\SuperMarket\\src\\main\\webapp\\Excel\\text.xlsx");
        File file = base;
        FileOutputStream outputStream = null;
        try {
            Workbook workbook = getWorkbok(file);
            Sheet sheet = workbook.getSheetAt(0);
            int rowNumber = sheet.getLastRowNum();
            System.out.println("原始数据总行数，除属性列：" + rowNumber);

            Field[] fields = Commodity.class.getDeclaredFields();
            List<String> propertyName = Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());

            List<Method> methodList = Arrays.stream(Commodity.class.getDeclaredMethods()).filter(method-> method.getName().startsWith("g")).collect(Collectors.toList());
            List<Method> newMethod = new ArrayList<>();

            Row firstRow = sheet.createRow(0);
            Cell[] cells = new Cell[10];
            int size = propertyName.size();
            for (int i = 0; i <  size; i++) {
                cells[i] = firstRow.createCell(i);
                for (int j = 0;  j  < size; j++) {
                    Method method = methodList.get(j);
                    if(method.getName().contains(propertyName.get(i).substring(1))) {
                        newMethod.add(method);
                    }
                }
            }
            for (int i = 1; i <= rowNumber; i++) {
                Row row = sheet.getRow(i);
                sheet.removeRow(row);
            }
            cells[0].setCellValue("编号");
            cells[1].setCellValue("商品名称");
            cells[2].setCellValue("价格");
            cells[3].setCellValue("是否打折");
            cells[4].setCellValue("打折开始于");
            cells[5].setCellValue("打折结束于");
            cells[6].setCellValue("二维码");




            for (int i = 0; i < list.size(); i++) {
                Row row = sheet.createRow(i + 1);
                Commodity commodity = list.get(i);
                for (int j = 0; j <  propertyName.size(); j++) {
                    Method method = newMethod.get(j);
                    Object object = method.invoke(commodity);
                    String value =  object == null ? "" : object.toString();
                    System.out.println(value);
                    Cell cell = row.createCell(j);
                    cell.setCellValue(value);
                }
            }

//            List<Row> rowList = list.forEach(sheet::getRow);
//            for (int i = 1; i < list.size(); i++) {
//                Row row = sheet.getRow(i);
//                List<Cell> cellList;
//                propertyName.forEach(row.createCell() -> cellList.add().);
//
//            }
            outputStream = new FileOutputStream(file);
            workbook.write(outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static Workbook getWorkbok(File file) throws IOException {
        Workbook wb = null;
        FileInputStream in = new FileInputStream(file);
        if (file.getName().endsWith(EXCEL_XLS)) {     //Excel&nbsp;2003
            wb = new HSSFWorkbook(in);
        } else if (file.getName().endsWith(EXCEL_XLSX)) {    // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }
    @RequestMapping(value = "/down")
    public void down(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //模拟文件，myfile.txt为需要下载的文件

        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File("C:\\Users\\11291\\SuperMarket\\src\\main\\webapp\\Excel\\text.xlsx")));
        //假如以中文名下载的话
        String filename = "商品列表.xlsx";
        //转码，免得文件名中文乱码
        filename = URLEncoder.encode(filename, "UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while ((len = bis.read()) != -1) {
            out.write(len);
            out.flush();
        }
        out.close();
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


    @RequestMapping(value = "/uploade", method = RequestMethod.POST)
    public String uplode(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws IOException {
        String path = "";
        if (!file.isEmpty()) {
//            生成uuid作为文件名称
            String uuid = UUID.randomUUID().toString().replaceAll("-", "");
            //获得文件类型（可以判断如果不是图片，禁止上传）
            // String contentType = file.getContentType();
            //获得文件后缀名称
            //  String imageName = contentType.substring(contentType.indexOf("/") + 1);
            path = "C:\\Users\\11291\\SuperMarket\\src\\main\\webapp\\Excel\\" + "commodity" + uuid + "." + "xlsx";
            file.transferTo(new File(path));
        }
        File file1 =new File(path);
        Commodity commodity = new Commodity();
        List<Commodity> list = ExcelUtils.readExcel(file1, commodity);
        for (Commodity c : list) {
            commodityService.create(c);
        }
        return "redirect:list";
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
