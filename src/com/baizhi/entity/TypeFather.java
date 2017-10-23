package com.baizhi.entity;

import java.util.List;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class TypeFather {
    private Integer type_father_id;
    private String type_father_name;
    private Integer type_father_count;
    private List<TypeSon> typeSons;

    public TypeFather() {
    }

    public TypeFather(Integer type_father_id, String type_father_name, Integer type_father_count, List<TypeSon> typeSons) {
        this.type_father_id = type_father_id;
        this.type_father_name = type_father_name;
        this.type_father_count = type_father_count;
        this.typeSons = typeSons;
    }

    public Integer getType_father_id() {
        return type_father_id;
    }

    public void setType_father_id(Integer type_father_id) {
        this.type_father_id = type_father_id;
    }

    public String getType_father_name() {
        return type_father_name;
    }

    public void setType_father_name(String type_father_name) {
        this.type_father_name = type_father_name;
    }

    public Integer getType_father_count() {
        return type_father_count;
    }

    public void setType_father_count(Integer type_father_count) {
        this.type_father_count = type_father_count;
    }

    public List<TypeSon> getTypeSons() {
        return typeSons;
    }

    public void setTypeSons(List<TypeSon> typeSons) {
        this.typeSons = typeSons;
    }

    @Override
    public String toString() {
        return "TypeFather{" +
                "type_father_id=" + type_father_id +
                ", type_father_name='" + type_father_name + '\'' +
                ", type_father_count=" + type_father_count +
                ", typeSons=" + typeSons +
                '}';
    }
}
