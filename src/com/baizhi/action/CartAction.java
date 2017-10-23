package com.baizhi.action;

import com.baizhi.entity.Goods;
import com.baizhi.service.CartService;
import com.baizhi.service.GoodsService;
import com.baizhi.service.impl.CartServiceImpl;
import com.baizhi.service.impl.GoodsServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 13:22 2017/10/16
 * @Descripon :
 */
public class CartAction extends ActionSupport {

    private Integer good_id;
    private Integer count;
    public Integer getGood_id() {
        return good_id;
    }

    public void setGood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String addGoodsAction() {

        GoodsService goodsService = new GoodsServiceImpl();
        Goods goods = goodsService.shwoBookDetailById(good_id);
        System.out.println(goods.getGood_id());
        CartService cartService = new CartServiceImpl();
        cartService.add(goods);


        return "success";
    }


    public String  deleteGoodsAction(){

        CartService cartService = new CartServiceImpl();
        cartService.delete(good_id);

        return "success";
    }


    public String  recoveryGoodsAction(){

        CartService cartService = new CartServiceImpl();
        cartService.recovery(good_id);

        return "success";
    }


    public String  updateGoodsAction(){

        CartService cartService = new CartServiceImpl();
        cartService.update(good_id,count);

        return "success";
    }

}
