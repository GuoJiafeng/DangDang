package com.baizhi.entity;

import java.util.Date;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class Order {
    private Integer order_id;
    private Date order_create_time;
    private Date order_delivery_time;
    private Date order_getdelivery_time;
    private Boolean order_status;
    private Double order_total_price;
    private Address address;
    private User user;

    public Order() {
    }

    public Order(Integer order_id, Date order_create_time, Date order_delivery_time, Date order_getdelivery_time, Boolean order_status, Double order_total_price, Address address, User user) {
        this.order_id = order_id;
        this.order_create_time = order_create_time;
        this.order_delivery_time = order_delivery_time;
        this.order_getdelivery_time = order_getdelivery_time;
        this.order_status = order_status;
        this.order_total_price = order_total_price;
        this.address = address;
        this.user = user;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Date getOrder_create_time() {
        return order_create_time;
    }

    public void setOrder_create_time(Date order_create_time) {
        this.order_create_time = order_create_time;
    }

    public Date getOrder_delivery_time() {
        return order_delivery_time;
    }

    public void setOrder_delivery_time(Date order_delivery_time) {
        this.order_delivery_time = order_delivery_time;
    }

    public Date getOrder_getdelivery_time() {
        return order_getdelivery_time;
    }

    public void setOrder_getdelivery_time(Date order_getdelivery_time) {
        this.order_getdelivery_time = order_getdelivery_time;
    }

    public Boolean getOrder_status() {
        return order_status;
    }

    public void setOrder_status(Boolean order_status) {
        this.order_status = order_status;
    }

    public Double getOrder_total_price() {
        return order_total_price;
    }

    public void setOrder_total_price(Double order_total_price) {
        this.order_total_price = order_total_price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_create_time=" + order_create_time +
                ", order_delivery_time=" + order_delivery_time +
                ", order_getdelivery_time=" + order_getdelivery_time +
                ", order_status=" + order_status +
                ", order_total_price=" + order_total_price +
                ", address=" + address +
                ", user=" + user +
                '}';
    }
}
