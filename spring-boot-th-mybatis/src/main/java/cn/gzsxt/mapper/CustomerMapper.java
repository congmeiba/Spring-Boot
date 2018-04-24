package cn.gzsxt.mapper;

import cn.gzsxt.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {

    public int insertCustomer(Customer customer);
}
