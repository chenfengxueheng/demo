package com.xb.demo.Excelutil;

import com.xb.demo.entity.User;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.validator.constraints.ModCheck;

import javax.jnlp.UnavailableServiceException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 读取表格的第一张表的五列数据
 */
public class ExcelUtil {
    public List<User> readExcel(InputStream is){
        List<User> userList=new ArrayList<User>();
        XSSFWorkbook wb=null;
        try {
            wb = new XSSFWorkbook(is);
            Sheet sheet = wb.getSheetAt(0);
            int n= sheet.getLastRowNum();//行数
            for (int i=0; i<n; i++){
                Row row = sheet.getRow(i);
                User user=new User();
                Cell cell1 = row.getCell(0);
                cell1.setCellType(CellType.STRING);
                user.setName(cell1.getStringCellValue());

                Cell cell2 = row.getCell(1);
                cell2.setCellType(CellType.STRING);
                user.setPhonenum(cell2.getStringCellValue());

                Cell cell3 = row.getCell(2);
                cell3.setCellType(CellType.STRING);
                user.setAddress(cell3.getStringCellValue());
                Cell cell4 = row.getCell(3);
                cell4.setCellType(CellType.STRING);
                user.setProductName(cell4.getStringCellValue());
                Cell cell5 = row.getCell(4);
                cell5.setCellType(CellType.STRING);
                user.setNum(cell5.getStringCellValue());
                userList.add(user);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }finally{
            try {
                wb.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return userList;
    }

}
