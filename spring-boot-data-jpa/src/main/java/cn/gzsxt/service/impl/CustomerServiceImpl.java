package cn.gzsxt.service.impl;

import cn.gzsxt.dao.CustomerDao;
import cn.gzsxt.entity.Customer;
import cn.gzsxt.service.CustomerService;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Resource
    private CustomerDao customerDao;

    @Override
    @Transactional
    @Modifying
    public Customer insertCustomer(Customer customer) {
        return customerDao.save(customer);
    }

}
