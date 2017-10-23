package com.baizhi.dao;

import com.baizhi.entity.User;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 12:50 2017/10/17
 * @Descripon :
 */
public interface UserDao {
    //插入操作
    void insertUser(User user);
    //更新操作
    void updateUser(User user);
    //删除操作
    void deleteUserById();


    //查询操作
    //查询用户by 用户名；
    User selectUserByUserName(String userName);
}
