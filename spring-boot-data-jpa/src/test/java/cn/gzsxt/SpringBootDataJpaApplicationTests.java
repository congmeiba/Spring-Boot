package cn.gzsxt;

import cn.gzsxt.entity.Customer;
import cn.gzsxt.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDataJpaApplicationTests {

    @Resource
    private CustomerService customerService;

    @Test
    public void contextLoads() {
        Customer customer = new Customer();
        customer.setName("张三");
        customer.setGender("男");
        customer.setAddrs("广州天河");
        customer.setPhone("13924027112");
        customer = customerService.insertCustomer(customer);
        System.out.println(customer);
    }

}
