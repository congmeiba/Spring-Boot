package cn.gzsxt.controller;

import cn.gzsxt.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping(value = "/list")
    public String list(Model map){
        List<User> list = new ArrayList<User>();
        User u1 = new User(1,"小王",16);
        User u2 = new User(1,"小陈",18);
        User u3 = new User(1,"小黄",20);
        list.add(u1);
        list.add(u2);
        list.add(u3);
        map.addAttribute("list1",list);
        //使用Freemarker 返回的类型是ftl,放在resources 下的 templates文件下的
        return "list";
    }


}
