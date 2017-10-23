package com.baizhi.service;

import com.baizhi.entity.User;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 13:26 2017/10/17
 * @Descripon :
 */
public interface UserService {
    String userRegister(User user, String code);

    String mailCheck(String emil,String code);

    String  userLogin(User user);
    String logout();
}
