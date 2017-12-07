package com.xb.demo;

import com.xb.demo.Excelutil.ExcelUtil;
import com.xb.demo.entity.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class testexcel {
    public static void main(String[] args) throws FileNotFoundException {
        File f=new File("J:\\example.xlsx");
        System.out.println(f);
        InputStream is=new FileInputStream(f);;
        ExcelUtil excelUtil=new ExcelUtil();
        List<User> userList=excelUtil.readExcel(is);
        System.out.println(userList.size());

    }
}
