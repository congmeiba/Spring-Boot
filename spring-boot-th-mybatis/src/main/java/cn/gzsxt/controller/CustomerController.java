package cn.gzsxt.controller;

import cn.gzsxt.entity.Customer;
import cn.gzsxt.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Resource
    private CustomerService customerService;

    @RequestMapping(value = "/main")
    public String saveUi(){
        return "main";
    }


    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String saveCustomer(Customer customer, ModelMap map){
        int flag = customerService.insertCustomer(customer);
        if(flag > 0){
            map.addAttribute("msg","添加成功");
        }else {
            map.addAttribute("msg","添加失败");
        }
        return "success";
    }

}
