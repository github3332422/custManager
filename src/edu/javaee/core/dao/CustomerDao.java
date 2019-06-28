package edu.javaee.core.dao;

import edu.javaee.core.po.Customer;

import java.util.List;

public interface CustomerDao {

    /**
     * 获取客户列表
     * */
    public List<Customer> selectCustomerList(Customer customer);

    /**
     * 获取客户数
     * */
    public Integer selectCustomerListCount(Customer customer);

    /**
     * 创建客户
     * */
    public int createCustomer(Customer customer);

    /**
     * 通过id查询用户
     * */
    public Customer getCustomerById(Integer id);

    /**
     * 更新客户信息
     * */
    public int updateCustomer(Customer customer);

    /**
     * 删除客户
     * */
    public int deleteCustomer(Integer id);
}
