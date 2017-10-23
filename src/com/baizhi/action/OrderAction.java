package com.baizhi.action;

import com.baizhi.entity.Address;
import com.baizhi.entity.User;
import com.baizhi.service.AddressService;
import com.baizhi.service.OrderService;
import com.baizhi.service.impl.AddressServiceImpl;
import com.baizhi.service.impl.OrderServiceImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import java.util.List;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in  14:21 2017/10/18
 * @Descripon :
 */
public class OrderAction extends ActionSupport {
    private Address address;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String addOrderAction() {
        OrderService orderService  = new OrderServiceImpl();
        orderService.addOrder(address);
        return "success";
    }


}
