package cn.gzsxt.service.impl;

import cn.gzsxt.dao.CustomerDao;
import cn.gzsxt.entity.Customer;
import cn.gzsxt.service.CustomerService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Resource
    private CustomerDao customerDao;

    /**
     * @CacheEvict 在使用持久层操作添加或删除时,清除对应缓存的所有数据.
     * @param customer
     * @return
     */
    @Override
    @Transactional
    @Modifying
    @CacheEvict(value = "emp",allEntries = true)
    public Customer insertCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    /**
     * 使用@Cacheable 实现缓存
     * @return
     */
    @Cacheable("customer")
    @Override
    public List<Customer> findByAll(){
        return customerDao.findAll();
    }

    /**
     * @Cacheable 每次进去查询的时候,都会以key是否相同,如果相同那么就直接在缓存拿数据,
     * 如果不同,他会在查询一次放入缓存.
     *
     * #: 代表引用对象.
     *
     *
     * @param pagea
     * @return
     */
    @Cacheable(value = "customer",key = "#pagea.pageSize")
    @Override
    public List<Customer> findByAllPage(Pageable pagea){
        return customerDao.findAll(pagea).getContent();
    }

}
