package cn.gzsxt.controller;


import cn.gzsxt.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class thymeleafDemo {



    @RequestMapping("/demo1")
    public String demo1(HttpServletRequest request,ModelMap map){
        map.addAttribute("msg","这是一个thymeleaf的tes");
        //if判断
        map.addAttribute("gender","男");

        //switch
        map.addAttribute("gend","1");
        //迭代
        List<User> list = new ArrayList<User>();
        User u1 = new User(1,"小黄",11);
        User u2 = new User(1,"小陈",15);
        User u3 = new User(1,"小黄",20);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        map.addAttribute("list",list);
        //域对象
        request.setAttribute("request","${#httpSerlvetRequest.getAttribute('request')} 获取");
        request.getSession().setAttribute("session","session.seesion 获取");
        request.getSession().getServletContext().setAttribute("application","application.application 获取");

        //使用thymeleaf模板支持,要在resources下创建文件夹templates,里面对应返回的html
        return "success";
    }


}
