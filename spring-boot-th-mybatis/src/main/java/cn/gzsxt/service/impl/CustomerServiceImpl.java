package cn.gzsxt.service.impl;

import cn.gzsxt.entity.Customer;
import cn.gzsxt.mapper.CustomerMapper;
import cn.gzsxt.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    @Transactional
    public int insertCustomer(Customer customer) {
        return customerMapper.insertCustomer(customer);
    }
}
