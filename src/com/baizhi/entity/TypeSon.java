package com.baizhi.entity;

import java.util.List;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class TypeSon {
    private Integer type_son_id;
    private String type_son_name;
    private Integer type_son_count;


    public TypeSon() {
    }

    public TypeSon(Integer type_son_id, String type_son_name, Integer type_son_count) {
        this.type_son_id = type_son_id;
        this.type_son_name = type_son_name;
        this.type_son_count = type_son_count;
    }

    public Integer getType_son_id() {
        return type_son_id;
    }

    public void setType_son_id(Integer type_son_id) {
        this.type_son_id = type_son_id;
    }

    public String getType_son_name() {
        return type_son_name;
    }

    public void setType_son_name(String type_son_name) {
        this.type_son_name = type_son_name;
    }

    public Integer getType_son_count() {
        return type_son_count;
    }

    public void setType_son_count(Integer type_son_count) {
        this.type_son_count = type_son_count;
    }

    @Override
    public String toString() {
        return "TypeSon{" +
                "type_son_id=" + type_son_id +
                ", type_son_name='" + type_son_name + '\'' +
                ", type_son_count=" + type_son_count +
                '}';
    }
}
