package edu.javaee.core.web.controller;

import edu.javaee.common.util.Page;
import edu.javaee.core.po.BaseDict;
import edu.javaee.core.po.Customer;
import edu.javaee.core.po.User;
import org.springframework.ui.Model;
import edu.javaee.core.service.BaseDictService;
import edu.javaee.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @program: customerManager
 * @description: ..
 * @author: 张清
 * @create: 2019-06-28 09:10
 **/
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private BaseDictService baseDictService;

    @Value("${customer.from.type}")
    private String FROM_TYPE;

    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;

    @Value("${customer.level.type}")
    private String LEVEL_TYPE;

    /**
     * 客户列表
     * */
    @RequestMapping(value = "/customer/list.action")
    public String list(@RequestParam(defaultValue="1")Integer page,
                       @RequestParam(defaultValue="10")Integer rows,
                       String custName, String custSource, String custIndustry,
                       String custLevel, Model model) {
        // 条件查询所有客户
        Page<Customer> customers = customerService.findCustomerList(page, rows, custName,
                custSource, custIndustry,custLevel);
//        System.out.println("controller" + customers);
        model.addAttribute("page", customers);
        // 客户来源
        List<BaseDict> fromType = baseDictService
                .findBaseDictByTypeCode(FROM_TYPE);
//        System.out.println("fromType" + fromType);
        // 客户所属行业
        List<BaseDict> industryType = baseDictService
                .findBaseDictByTypeCode(INDUSTRY_TYPE);
//        System.out.println("industryType" + industryType);
        // 客户级别
        List<BaseDict> levelType = baseDictService
                .findBaseDictByTypeCode(LEVEL_TYPE);
//        System.out.println("levelType" + levelType);
        // 添加参数
        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);
        model.addAttribute("custName", custName);
        model.addAttribute("custSource", custSource);
        model.addAttribute("custIndustry", custIndustry);
        model.addAttribute("custLevel", custLevel);
        return "customer";
    }

    /**
     * 创建客户
     * */
    @RequestMapping("/customer/create.action")
    @ResponseBody
    public String customerCreate(Customer customer, HttpSession session){
        User user = (User) session.getAttribute("USER_SESSION");
        //获取创建该用户的id
        customer.setCust_create_id(user.getUser_id());
        //得到一个TimeStamp格式
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        customer.setCust_createtime(timestamp);

        int rows = customerService.createCustomer(customer);
        if (rows > 0){
            return "OK";
        }
        else{
            return "FALL";
        }
    }

    /**
     * 通过id获取用户信息
     * */
    @RequestMapping(value = "/customer/getCustomerById.action")
    @ResponseBody
    public Customer getCustomerById(Integer id) {
        Customer customer = customerService.getCustomerById(id);
//        System.out.println(customer);
        return customer;
    }

    /**
     * 更新客户
     * */
    @RequestMapping(value = "/customer/update.action")
    @ResponseBody
    public String customerUpdate(Customer customer){
        int rows = customerService.updateCustomer(customer);
        if(rows > 0){
            return "OK";
        }
        else{
            return "FALL";
        }
    }

    /**
     * 删除用户
     * */
    @RequestMapping(value = "/customer/delete.action")
    @ResponseBody
    public String customerDelete(Integer id){
        int rows = customerService.deleteCustomer(id);
        if(rows > 0){
            return "OK";
        }
        else{
            return "FALL";
        }
    }
}
