package com.baizhi.entity;

import java.util.Date;

/**
 * @Author :Create by Guo Jiafeng
 * @Date : Created in 15:45 2017/9/16
 * @Descripon :
 */
public class User {
    private Integer user_id;
    private String user_email;
    private String user_nickname;
    private String user_password;
    private String user_salt;
    private Boolean user_status;
    private Double user_score;
    private Date user_login_time;

    public User() {
    }

    public User(Integer user_id, String user_email, String user_nickname, String user_password, String user_salt, Boolean user_status, Double user_score, Date user_login_time) {
        this.user_id = user_id;
        this.user_email = user_email;
        this.user_nickname = user_nickname;
        this.user_password = user_password;
        this.user_salt = user_salt;
        this.user_status = user_status;
        this.user_score = user_score;
        this.user_login_time = user_login_time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_nickname() {
        return user_nickname;
    }

    public void setUser_nickname(String user_nickname) {
        this.user_nickname = user_nickname;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_salt() {
        return user_salt;
    }

    public void setUser_salt(String user_salt) {
        this.user_salt = user_salt;
    }

    public Boolean getUser_status() {
        return user_status;
    }

    public void setUser_status(Boolean user_status) {
        this.user_status = user_status;
    }

    public Double getUser_score() {
        return user_score;
    }

    public void setUser_score(Double user_score) {
        this.user_score = user_score;
    }

    public Date getUser_login_time() {
        return user_login_time;
    }

    public void setUser_login_time(Date user_login_time) {
        this.user_login_time = user_login_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_email='" + user_email + '\'' +
                ", user_nickname='" + user_nickname + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_salt='" + user_salt + '\'' +
                ", user_status=" + user_status +
                ", user_score=" + user_score +
                ", user_login_time=" + user_login_time +
                '}';
    }
}
