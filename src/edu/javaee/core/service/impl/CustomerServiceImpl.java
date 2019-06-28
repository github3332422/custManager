package edu.javaee.core.service.impl;

import edu.javaee.common.util.Page;
import edu.javaee.core.dao.CustomerDao;
import edu.javaee.core.po.Customer;
import edu.javaee.core.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: customerManager
 * @description: , , ,
 * @author: 张清
 * @create: 2019-06-28 09:06
 **/
@Service("customerServicer")
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

    /**
     * 查询客户列表
     * */
    public Page<Customer> findCustomerList(Integer page, Integer rows,
                                           String custName, String custSource, String custIndustry,
                                           String custLevel) {
        // 创建客户对象
        Customer customer = new Customer();
        // 判断客户名称
        if(StringUtils.isNotBlank(custName)){
            customer.setCust_name(custName);
        }
        // 判断客户信息来源
        if(StringUtils.isNotBlank(custSource)){
            customer.setCust_source(custSource);
        }
        // 判断客户所属行业
        if(StringUtils.isNotBlank(custIndustry)){
            customer.setCust_industry(custIndustry);
        }
        // 判断客户级别
        if(StringUtils.isNotBlank(custLevel)){
            customer.setCust_level(custLevel);
        }
        // 当前页
        customer.setStart((page-1) * rows) ;
        // 每页数
        customer.setRows(rows);
        // 查询客户列表
        List<Customer> customers =
                customerDao.selectCustomerList(customer);
        // 查询客户列表总记录数
        Integer count = customerDao.selectCustomerListCount(customer);
        // 创建Page返回对象
//        System.out.println("Service" + );
        Page<Customer> result = new Page<>();
        result.setPage(page);
        result.setRows(customers);
        result.setSize(rows);
        result.setTotal(count);
        return result;
    }

    /**
     * 创建客户
     * */
    public int createCustomer(Customer customer) {
        return customerDao.createCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Integer id) {
        return customerDao.getCustomerById(id);
    }

    @Override
    public int updateCustomer(Customer customer) {
        return customerDao.updateCustomer(customer);
    }

    @Override
    public int deleteCustomer(Integer id) {
        return customerDao.deleteCustomer(id);
    }
}
