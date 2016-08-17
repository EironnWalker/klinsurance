package com.ht.klinsurance.customer.service.Impl;

import com.ht.klinsurance.customer.mapper.CustomerMapper;
import com.ht.klinsurance.customer.model.Customer;
import com.ht.klinsurance.customer.service.ICustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 客户信息同步
 *
 * @author liuqi
 * @date 2016/7/22
 */
@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
    @Resource
    private CustomerMapper customerMapper;
    @Override
    public int addCustmer(Customer customer) {
        customerMapper.addCustomer(customer);
        return 0;
    }

    @Override
    public List<Customer> findCustomer(Map<String, Object> parameter) {
        return customerMapper.findCustomerList(parameter);
    }
}
