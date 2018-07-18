package com.sm.Tools;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExcelUtils{
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    /**
     * @T 目标类型
     */
    public static <T> List<T> readExcel(File file, T t) {
        try {
           // InputStream inputStream = new FileInputStream(file.getAbsolutePath());
            List<List<String>> readList =new ArrayList<List<String>>();

            // 创建输入流，读取Excel
            // jxl提供的Workbook类
            Workbook wb = getWorkbok(file);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            List<Method> methodList = getMethod( t);
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
            List<T> objectList = new ArrayList<>();
            for (int i = 1; i < readList.size(); i++ ) {
                List<String> list = readList.get(i);
                T tt = (T) t.getClass().newInstance();
                for (int j = 0; j < list.size(); j++) {
                    Class<?>[] type = methodList.get(j).getParameterTypes();
                    String typeName = type[0].getName();

                    switch (typeName){
                        case "int":
                            methodList.get(j).invoke(tt, Integer.valueOf( list.get(j)));
                            break;

                        case "java.lang.String":
                            methodList.get(j).invoke(tt, (String)list.get(j));
                            break;
                    }

                }
                objectList.add(tt);
            }
            System.out.println(objectList);

            return objectList;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } finally {
        }

        return null;
    }
    public static <T> List<Method> getMethod(T t) {
        Field[] fields = t.getClass().getDeclaredFields();
        List<String> propertyName = Arrays.stream(fields).map(Field::getName).collect(Collectors.toList());

        List<Method> methodList = Arrays.stream(t.getClass().getDeclaredMethods()).filter(method-> method.getName().startsWith("s")).collect(Collectors.toList());

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
