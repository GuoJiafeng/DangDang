package com.baizhi.service;

import com.baizhi.entity.Address;
import com.baizhi.entity.User;

import java.util.List;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 19:59 2017/10/17
 * @Descripon :
 */
public interface AddressService {
    //插入地址
    String insertAddress(Address address, User user);

    //更新地址
    void updateAddress(Address address);

    //查询地址
    Address selectAddressByAddressId(Integer id);

    List<Address> selectAddressByUserId(Integer id);
}
