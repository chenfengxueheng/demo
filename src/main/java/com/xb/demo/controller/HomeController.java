package com.xb.demo.controller;


import com.xb.demo.Excelutil.ExcelUtil;
import com.xb.demo.entity.User;

import net.sf.json.JSONArray;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;



@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})
@Controller
@EnableAutoConfiguration
@RequestMapping("/")
public class HomeController {
    @RequestMapping("/")
    public  String index(Model model){
        User user=new User();
        user.setName("尘封雪恒");
        model.addAttribute("name","尘封雪恒");
        System.out.println("尘封雪恒1");
        return "ecxelupload";
    }
    @RequestMapping("/excel")
    public void excel(HttpServletRequest request, HttpServletResponse response, @RequestParam(value ="filename" ) MultipartFile file) throws IOException {

        ExcelUtil excelUtil=new ExcelUtil();
        List<User> userList=excelUtil.readExcel(file.getInputStream());

       JSONArray listArray= JSONArray.fromObject(userList);
        //System.out.println(listArray.toString());
        response.setCharacterEncoding("UTF-8");
        PrintWriter out= response.getWriter();
        out.write(listArray.toString());


    }

}
