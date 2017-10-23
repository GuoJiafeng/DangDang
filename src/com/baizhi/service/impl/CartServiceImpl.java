package com.baizhi.service.impl;

import com.baizhi.entity.Cart;
import com.baizhi.entity.CartItem;
import com.baizhi.entity.Goods;
import com.baizhi.service.CartService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class CartServiceImpl implements CartService {
    @Override
    public void add(Goods goods) {
        //第一步找到我的车
        ValueStack vs = ActionContext.getContext().getValueStack();
        Cart cart = (Cart) vs.findValue("#session.cart");
        //创建购物车
        if (cart == null) {
            cart = new Cart();
        }
        //如果购车出包含此商品
        if (cart.getMap() != null && !cart.getMap().isEmpty()) {
            if (cart.getMap().containsKey(goods.getGood_id())) {
                //通过id获取map中的cartItem
                CartItem cartItem = cart.getMap().get(goods.getGood_id());
                //加上原来购物车里的
                if (cart.getRemoveMap() != null && !cart.getRemoveMap().isEmpty()) {
                    if (cart.getRemoveMap().containsKey(goods.getGood_id())) {
                        cartItem.setCount(cartItem.getCount() + cart.getRemoveMap().get(goods.getGood_id()).getCount());
                        cart.getRemoveMap().remove(goods.getGood_id());
                    }
                }
                //将数量加1
                cartItem.setCount(cartItem.getCount() + 1);
                //将小记加上商品的价格
                cartItem.setLittleSave(cartItem.getLittleSave() + goods.getGood_dangdang_price());
            } else {
                //加入购物车中没有商品
                CartItem cartItem = new CartItem();
                //设置cartItem中的商品
                cartItem.setGoods(goods);
                //第一次添加商品的数量为1
                //加上原来购物车里的
                if (cart.getRemoveMap() != null && !cart.getRemoveMap().isEmpty()) {
                    if (cart.getRemoveMap().containsKey(goods.getGood_id())) {
                        cartItem.setCount(cart.getRemoveMap().get(goods.getGood_id()).getCount() + 1);
                        cart.getRemoveMap().remove(goods.getGood_id());
                    } else {
                        cartItem.setCount(1);
                    }
                } else {
                    cartItem.setCount(1);
                }
                //设置小计
                cartItem.setLittleSave(goods.getGood_dangdang_price());
                //最后将cartItem赋值到Caret中，goodid也赋值
                cart.getMap().put(goods.getGood_id(), cartItem);
            }
        } else {
            //加入购物车中没有商品
            CartItem cartItem = new CartItem();
            //设置cartItem中的商品
            cartItem.setGoods(goods);
            //第一次添加商品的数量为1
            //加上原来购物车里的
            if (cart.getRemoveMap() != null && !cart.getRemoveMap().isEmpty()) {
                if (cart.getRemoveMap().containsKey(goods.getGood_id())) {
                    cartItem.setCount(cart.getRemoveMap().get(goods.getGood_id()).getCount() + 1);
                    cart.getRemoveMap().remove(goods.getGood_id());
                } else {
                    cartItem.setCount(1);
                }
            } else {
                cartItem.setCount(1);
            }
            //设置小计
            cartItem.setLittleSave(goods.getGood_dangdang_price() * cartItem.getCount());
            //最后将cartItem赋值到Caret中，goodid也赋值
            Map<Integer, CartItem> map = new HashMap<>();
            map.put(goods.getGood_id(), cartItem);
            cart.setMap(map);
        }
        //j计算购物车总价
        calculation(cart);
    }

    @Override
    public void delete(Integer id) {
        //第一步找到我的车
        ValueStack vs = ActionContext.getContext().getValueStack();
        Cart cart = (Cart) vs.findValue("#session.cart");
        //通过id获取到map中cartItem
        CartItem cartItem = cart.getMap().get(id);
        if (cart.getRemoveMap() != null && !cart.getRemoveMap().isEmpty()) {
            cart.getRemoveMap().put(id, cartItem);
            //删除原来map中的cartItem对象
            cart.getMap().remove(id);
        } else {
            //实例化一个Map对象
            Map<Integer, CartItem> map = new HashMap<>();
            //赋值
            map.put(id, cartItem);
            //将获取到cartItem对象添加到removeMap中
            cart.setRemoveMap(map);
            //删除原来map中的cartItem对象
            cart.getMap().remove(id);
        }
        //j计算购物车总价
        calculation(cart);
    }

    @Override
    public void update(Integer id, Integer count) {
        //第一步找到我的车
        ValueStack vs = ActionContext.getContext().getValueStack();
        Cart cart = (Cart) vs.findValue("#session.cart");
        //通过id获取map中的cartItem
        CartItem cartItem = cart.getMap().get(id);
        //将数量加1
        cartItem.setCount(count);
        //将小记加上商品的价格
        cartItem.setLittleSave(cartItem.getGoods().getGood_dangdang_price() * count);
        calculation(cart);
    }

    @Override
    public void recovery(Integer id) {
        //第一步找到我的车
        ValueStack vs = ActionContext.getContext().getValueStack();
        Cart cart = (Cart) vs.findValue("#session.cart");
        //通过id获取到removeMap中cartItem
        CartItem cartItem = cart.getRemoveMap().get(id);
        //实例化一个Map对象
        //将获取到cartItem对象添加到Map中
        cart.getMap().put(id, cartItem);
        //删除原来map中的cartItem对象
        cart.getRemoveMap().remove(id);
        //j计算购物车总价
        calculation(cart);
    }

    @Override
    public void calculation(Cart cart) {
        //j计算购物车总价
        ValueStack vs = ActionContext.getContext().getValueStack();
        //首先设置一个sum
        Double sum = 0.0;
        Double sum2 = 0.0;
        //遍历map
        for (Map.Entry<Integer, CartItem> entry : cart.getMap().entrySet()) {
            CartItem cartItem1 = entry.getValue();
            Double littleSave = cartItem1.getLittleSave();
            Double price = cartItem1.getCount() * cartItem1.getGoods().getGood_price();
            sum += littleSave;
            sum2 += price;
        }
        cart.setTotalSavePrice(sum);
        cart.setTotalPrice(sum2);
        vs.setValue("#session.cart", cart);
    }
}
