package cn.gzsxt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    @ResponseBody
    public Map<String,Object> hello(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("hello","Spring-Boot");
        return map;
    }
}
