package com.baizhi.entity;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class Address {
    private Integer address_id;
    private String address_detail;
    private Integer address_post_number;
    private String address_user_name;
    private String address_user_phone;
    private String address_user_mobile_phone;
    private User user;

    public Address() {
    }

    public Address(Integer address_id, String address_detail, Integer address_post_number, String address_user_name, String address_user_phone, String address_user_mobile_phone, User user) {
        this.address_id = address_id;
        this.address_detail = address_detail;
        this.address_post_number = address_post_number;
        this.address_user_name = address_user_name;
        this.address_user_phone = address_user_phone;
        this.address_user_mobile_phone = address_user_mobile_phone;
        this.user = user;
    }

    public Integer getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Integer address_id) {
        this.address_id = address_id;
    }

    public String getAddress_detail() {
        return address_detail;
    }

    public void setAddress_detail(String address_detail) {
        this.address_detail = address_detail;
    }

    public Integer getAddress_post_number() {
        return address_post_number;
    }

    public void setAddress_post_number(Integer address_post_number) {
        this.address_post_number = address_post_number;
    }

    public String getAddress_user_name() {
        return address_user_name;
    }

    public void setAddress_user_name(String address_user_name) {
        this.address_user_name = address_user_name;
    }

    public String getAddress_user_phone() {
        return address_user_phone;
    }

    public void setAddress_user_phone(String address_user_phone) {
        this.address_user_phone = address_user_phone;
    }

    public String getAddress_user_mobile_phone() {
        return address_user_mobile_phone;
    }

    public void setAddress_user_mobile_phone(String address_user_mobile_phone) {
        this.address_user_mobile_phone = address_user_mobile_phone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", address_detail='" + address_detail + '\'' +
                ", address_post_number=" + address_post_number +
                ", address_user_name='" + address_user_name + '\'' +
                ", address_user_phone='" + address_user_phone + '\'' +
                ", address_user_mobile_phone='" + address_user_mobile_phone + '\'' +
                ", user=" + user +
                '}';
    }
}
