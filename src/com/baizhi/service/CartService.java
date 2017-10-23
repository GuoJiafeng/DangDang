package com.baizhi.service;

import com.baizhi.entity.Cart;
import com.baizhi.entity.Goods;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public interface CartService {
    //添加商品
    void add(Goods goods);

    //删除商品
    void delete(Integer id) ;

    //恢复商品
    void recovery(Integer id);

    //更新商品
    void update(Integer id,Integer count);

    //计算总价格
    void calculation(Cart cart);
}
