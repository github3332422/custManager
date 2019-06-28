package edu.javaee.core.dao;

import edu.javaee.core.po.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    /**
     * 实现用户登录
     * */
    public User findUser(@Param("usercode") String usercode,
                         @Param("password") String password);
}
