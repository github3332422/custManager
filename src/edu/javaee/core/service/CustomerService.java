package edu.javaee.core.service;

import edu.javaee.common.util.Page;
import edu.javaee.core.po.Customer;

public interface CustomerService {
    /**
     * 按页查询客户
     * */
    public Page<Customer> findCustomerList(Integer age, Integer rows, String custName,
                                           String custSource, String custIndusty,
                                           String custLevel);
    /**
     * 创建客户
     * */
    public int createCustomer(Customer customer);

    /**
     * 通过id获取客户
     * */
    public Customer getCustomerById(Integer id);

    /**
     * 更新客户
     * */
    public int updateCustomer(Customer customer);

    /**
     * 删除客户
     * */
    public int deleteCustomer(Integer id);

}
