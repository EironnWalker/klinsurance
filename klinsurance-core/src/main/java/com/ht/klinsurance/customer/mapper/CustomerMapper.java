package com.ht.klinsurance.customer.mapper;

import com.ht.klinsurance.customer.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CustomerMapper {
    int deleteByPrimaryKey(String customerId);

    int deleteAll();

    int addCustomer(Customer record);

    int addCustomerList(List<Customer> list);

    Customer selectByPrimaryKey(String customerId);

    int updateByPrimaryKeySelective(Customer record);


    List<Customer> findCustomerList(Map<String, Object> parameter);
}