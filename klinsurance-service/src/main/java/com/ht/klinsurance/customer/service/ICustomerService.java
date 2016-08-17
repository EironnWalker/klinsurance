package com.ht.klinsurance.customer.service;

import com.ht.klinsurance.customer.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * 客户相关
 * @author liuqi
 * @date 2016/8/9
 */
public interface ICustomerService {
    int addCustmer(Customer customer);

    List<Customer> findCustomer(Map<String, Object> parameter);
}
