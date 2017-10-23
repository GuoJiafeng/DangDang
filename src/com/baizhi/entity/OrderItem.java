package com.baizhi.entity;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class OrderItem {
    private Integer orderitem_id;
    private Integer orderitem_good_id;
    private Integer orderitem_count;
    private Double orderitem_price;
    private Double orderitem_totalPrice;
    private Order order;

    public OrderItem() {
    }

    public OrderItem(Integer orderitem_id, Integer orderitem_good_id, Integer orderitem_count, Double orderitem_price, Double orderitem_totalPrice, Order order) {
        this.orderitem_id = orderitem_id;
        this.orderitem_good_id = orderitem_good_id;
        this.orderitem_count = orderitem_count;
        this.orderitem_price = orderitem_price;
        this.orderitem_totalPrice = orderitem_totalPrice;
        this.order = order;
    }

    public Integer getOrderitem_id() {
        return orderitem_id;
    }

    public void setOrderitem_id(Integer orderitem_id) {
        this.orderitem_id = orderitem_id;
    }

    public Integer getOrderitem_good_id() {
        return orderitem_good_id;
    }

    public void setOrderitem_good_id(Integer orderitem_good_id) {
        this.orderitem_good_id = orderitem_good_id;
    }

    public Integer getOrderitem_count() {
        return orderitem_count;
    }

    public void setOrderitem_count(Integer orderitem_count) {
        this.orderitem_count = orderitem_count;
    }

    public Double getOrderitem_price() {
        return orderitem_price;
    }

    public void setOrderitem_price(Double orderitem_price) {
        this.orderitem_price = orderitem_price;
    }

    public Double getOrderitem_totalPrice() {
        return orderitem_totalPrice;
    }

    public void setOrderitem_totalPrice(Double orderitem_totalPrice) {
        this.orderitem_totalPrice = orderitem_totalPrice;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderitem_id=" + orderitem_id +
                ", orderitem_good_id=" + orderitem_good_id +
                ", orderitem_count=" + orderitem_count +
                ", orderitem_price=" + orderitem_price +
                ", orderitem_totalPrice=" + orderitem_totalPrice +
                ", order=" + order +
                '}';
    }
}

