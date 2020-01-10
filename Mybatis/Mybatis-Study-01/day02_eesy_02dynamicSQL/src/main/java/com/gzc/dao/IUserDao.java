package com.gzc.dao;

import com.gzc.domain.User;
import java.util.List;

public interface IUserDao {
    /**
     * 查询所有操作
     * @return
     */
    List<User> findAll();
    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);
    /**
     * 根据名称模糊查询用户信息
     * @param username
     * @return
     */
    List<User> findByName(String username);
    /**
     * 根据传入参数条件
     * @param user 查询的条件：有可能有用户名，有可能有性别，也有可能有地址，还有可能是都有
     * @return
     */
    List<User> findUserByCondition(User user);
}
