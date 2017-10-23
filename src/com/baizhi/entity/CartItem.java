package com.baizhi.entity;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class CartItem {
    private Integer id;
    private Goods goods;
    Integer count;
    Double littleSave;

    public CartItem() {
    }

    public CartItem(Integer id, Goods goods, Integer count, Double littleSave) {
        this.id = id;
        this.goods = goods;
        this.count = count;
        this.littleSave = littleSave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getLittleSave() {
        return littleSave;
    }

    public void setLittleSave(Double littleSave) {
        this.littleSave = littleSave;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", goods=" + goods +
                ", count=" + count +
                ", littleSave=" + littleSave +
                '}';
    }
}
