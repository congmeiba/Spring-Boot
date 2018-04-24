package cn.gzsxt.controller;

import cn.gzsxt.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class UserController {


    @RequestMapping("/toAdd")
    public String toAdd(User user){
        return "add";
    }

    /**
     * BindingResult:用于封装数据验证对象(user) 里面的验证结果
     * @Valid 告诉BindingResult 要验证这个对象
     * @param user
     * @param result
     * @return
     */
    @RequestMapping("/add")
    public String add(@Valid User user, BindingResult result){
        //判断是否有错误
        if(result.hasErrors()){
            return "add";
        }
        System.out.println(user);
        return "success";
    }


}
