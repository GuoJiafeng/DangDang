package com.baizhi.dao;

import com.baizhi.entity.Order;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 11:51 2017/10/18
 * @Descripon :
 */
public interface OrderDao {
    //插入order
    void insertOrder(Order order);

    //查询order
    Order selectOrederById(Integer id);

}
