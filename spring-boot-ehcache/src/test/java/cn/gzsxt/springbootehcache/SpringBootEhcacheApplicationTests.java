package cn.gzsxt.springbootehcache;

import cn.gzsxt.entity.Customer;
import cn.gzsxt.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootEhcacheApplicationTests {

    @Resource
    private CustomerService customerService;

    @Test
    public void contextLoads() {
        Customer customer = new Customer();
        customer.setName("李四");
        customer.setGender("男");
        customer.setAddrs("广州天河");
        customer.setPhone("13924027112");
        customer = customerService.insertCustomer(customer);
        System.out.println(customer);
    }


    @Test
    public void test1(){
        List<Customer> all = customerService.findByAll();
        System.out.println(all);
        all = customerService.findByAll();
        System.out.println(all);
    }

    @Test
    public void test2(){
        Pageable pageable = new PageRequest(0,1);
        List<Customer> all = customerService.findByAllPage(pageable);
        System.out.println(all);
        pageable = new PageRequest(1,1);
        all = customerService.findByAllPage(pageable);
        System.out.println(all);
    }




}
