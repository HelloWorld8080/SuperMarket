package com.sm.NewTechno;

import com.sm.Tools.ExcelUtils;
import com.sm.entity.Commodity;
import jxl.read.biff.BiffException;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadExcel {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";
    public static void main(String[] args) {
        ReadExcel obj = new ReadExcel();
        // 此处为我创建Excel路径：E:/zhanhj/studysrc/jxl下
        File file = new File("C:\\Users\\11291\\SuperMarket\\src\\main\\webapp\\Excel\\text.xlsx");
//        List excelList = obj.readExcel(file);
////        System.out.println("list中的数据打印出来");
////        for (int i = 0; i < excelList.size(); i++) {
////            List list = (List) excelList.get(i);
////            for (int j = 0; j < list.size(); j++) {
////                System.out.print(list.get(j) + "  ");
////            }
////            System.out.println();
////        }
        Commodity commodity = new Commodity();
        List<Commodity> list = ExcelUtils.readExcel(file, commodity);
        for (Commodity c : list) {
            System.out.println(c);
        }

    }
    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public List readExcel(File file) {
        try {
            List<List<String>> readList =new ArrayList<List<String>>();

            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = getWorkbok(file);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            List<Method> methodList = this.getMethod("s");
            for (int i = 0; i < sheet_size; i++) {
                Sheet sheet = wb.getSheetAt(i);
                for (Row row : sheet) {
                    List<String> temp = new ArrayList<>();
                    for (Cell cell : row) {
                        temp.add( cell.getStringCellValue().equals("")? "" : cell.getStringCellValue());
                    }
                    readList.add(temp);

                }
            }
            List<Commodity> commodityList = new ArrayList<>();
            for (int i = 1; i < readList.size(); i++ ) {
                List<String> list = readList.get(i);
                Commodity commodity = new Commodity();
                System.out.println(list.size());
                for (int j = 0; j < list.size(); j++) {
                   Class<?>[] type = methodList.get(j).getParameterTypes();
                   String t = type[0].getName();
                    System.out.println(t);
                   switch (t){
                       case "int":
                           methodList.get(j).invoke(commodity, Integer.valueOf( list.get(j)));
                           break;

                       case "java.lang.String":
                           methodList.get(j).invoke(commodity, (String)list.get(j));
                           break;
                   }

                }
                commodityList.add(commodity);
            }
            System.out.println(commodityList);

                return readList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return null;
    }
    public List<Method> getMethod(String name) {
        Field[] fields = Commodity.class.getDeclaredFields();
        List<String> propertyName = Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());

        List<Method> methodList = Arrays.stream(Commodity.class.getDeclaredMethods()).filter(method-> method.getName().startsWith("s")).collect(Collectors.toList());
        List<Method> newMethod = new ArrayList<>();


        int size = propertyName.size();
        for (int i = 0; i <  size; i++) {
            for (int j = 0;  j  < size; j++) {
                Method method = methodList.get(j);
                if(method.getName().contains(propertyName.get(i).substring(1))) {
                    newMethod.add(method);
                }
            }
        }
        return newMethod;
    }
    public static Workbook getWorkbok(File file) throws IOException{
        Workbook wb = null;
        FileInputStream in = new FileInputStream(file);
        if(file.getName().endsWith(EXCEL_XLS)){     //Excel&nbsp;2003
            wb = new HSSFWorkbook(in);
        }else if(file.getName().endsWith(EXCEL_XLSX)){    // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }
}