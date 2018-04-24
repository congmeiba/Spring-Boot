package cn.gzsxt.service;

import cn.gzsxt.entity.Customer;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {

    public Customer insertCustomer(Customer customer);

    public List<Customer> findByAll();

    public List<Customer> findByAllPage(Pageable pagea);

}
