package com.baizhi.service.impl;

import com.baizhi.dao.OrderDao;
import com.baizhi.dao.OrderItemDao;
import com.baizhi.entity.*;
import com.baizhi.service.AddressService;
import com.baizhi.service.OrderService;
import com.baizhi.util.MybatisUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.Map;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in  14:24 2017/10/18
 * @Descripon :
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public String addOrder(Address address) {
        SqlSession session = null;
        ValueStack vs = ActionContext.getContext().getValueStack();
        try {
            session = MybatisUtil.openSession();
            AddressService addressService = new AddressServiceImpl();
            User userFromSession = (User) vs.findValue("#session.user");
            OrderDao orderDao = (OrderDao) MybatisUtil.getDao(OrderDao.class);
            OrderItemDao orderItemDao = (OrderItemDao)MybatisUtil.getDao(OrderItemDao.class);
            Cart cart = (Cart) vs.findValue("#session.cart");
            if (address.getAddress_id() == null) {
                addressService.insertAddress(address, userFromSession);
            }else {

                addressService.updateAddress(address);
            }
            Order order = new Order();

            order.setOrder_total_price(cart.getTotalSavePrice());
            order.setOrder_status(false);
            order.setOrder_create_time(new Date());
            order.setAddress(address);
            order.setUser(userFromSession);

            orderDao.insertOrder(order);


            for (Map.Entry<Integer, CartItem> map : cart.getMap().entrySet()) {
                CartItem cartItem = map.getValue();
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderitem_count(cartItem.getCount());
                orderItem.setOrderitem_price(cartItem.getGoods().getGood_dangdang_price());
                orderItem.setOrderitem_totalPrice(cartItem.getLittleSave());
                orderItem.setOrderitem_good_id(cartItem.getGoods().getGood_id());
                orderItem.setOrder(order);
                orderItemDao.insertOrderItem(orderItem);

            }
            session.commit();
            //使用session存入订单号
            vs.setValue("#session.orderId", order.getOrder_id());
            vs.setValue("#session.totalPrice",order.getOrder_total_price());
            vs.setValue("#session.cart",null);

        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
            throw new RuntimeException(e.getMessage());
        } finally {
            MybatisUtil.close();
        }
        return null;
    }
}
