package cn.gzsxt.controller;

import cn.gzsxt.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class JspController {



    @RequestMapping(value = "/hello")
    public String jsp(ModelMap map){
        List<User> list = new ArrayList<User>();
        User u1 = new User(1,"小王",16);
        User u2 = new User(1,"小陈",18);
        User u3 = new User(1,"小黄",20);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        map.addAttribute("list",list);
        //Spring-boot 整合jsp 跟平常开发一样  给个webapp/WEB-INF/jsp
        //配置一下视图解析器的前缀和后缀.
        return "success";



    }

}
