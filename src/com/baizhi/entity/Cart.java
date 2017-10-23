package com.baizhi.entity;

import java.util.Map;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class Cart {

    Map<Integer, CartItem> map;
    Map<Integer, CartItem> removeMap;
    Double totalPrice;
    Double totalSavePrice;

    public Cart() {
    }

    public Cart(Map<Integer, CartItem> map, Map<Integer, CartItem> removeMap, Double totalPrice, Double totalSavePrice) {
        this.map = map;
        this.removeMap = removeMap;
        this.totalPrice = totalPrice;
        this.totalSavePrice = totalSavePrice;
    }

    public Map<Integer, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartItem> map) {
        this.map = map;
    }

    public Map<Integer, CartItem> getRemoveMap() {
        return removeMap;
    }

    public void setRemoveMap(Map<Integer, CartItem> removeMap) {
        this.removeMap = removeMap;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getTotalSavePrice() {
        return totalSavePrice;
    }

    public void setTotalSavePrice(Double totalSavePrice) {
        this.totalSavePrice = totalSavePrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "map=" + map +
                ", removeMap=" + removeMap +
                ", totalPrice=" + totalPrice +
                ", totalSavePrice=" + totalSavePrice +
                '}';
    }
}
