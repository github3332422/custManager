package edu.javaee.core.service;

import edu.javaee.core.po.User;

/**
 * @program: customerManager
 * @description: ..
 * @author: 张清
 * @create: 2019-06-27 23:01
 **/
public interface UserService {
    /**
     * 用户登录
     * */
    public User findUser(String usercode,String password);
}
