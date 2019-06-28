package edu.javaee.core.service.impl;

import edu.javaee.core.dao.UserDao;
import edu.javaee.core.po.User;
import edu.javaee.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: customerManager
 * @description: , ,
 * @author: 张清
 * @create: 2019-06-27 23:02
 **/
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User findUser(String usercode, String password) {
        return userDao.findUser(usercode,password);
    }
}
