package cn.gzsxt.test;

import cn.gzsxt.Application;
import cn.gzsxt.entity.Customer;
import cn.gzsxt.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class Demo1 {

    @Resource
    private CustomerService customerService;

    @Test
    public void test1(){
        Customer customer = new Customer();
        customer.setName("小陈");
        customer.setGender("女");
        customer.setPhone("13924027112");
        customer.setAddrs("广州番禺");
        customerService.insertCustomer(customer);
    }


}
