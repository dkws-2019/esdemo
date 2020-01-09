package com.liuchao.esdemo.entity;


//import org.springframework.data.annotation.Id;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;

import io.searchbox.annotations.JestId;

import java.util.Date;

//@Document(indexName = "logdemo",type = "user")
public class User {
    //@Id
    @JestId
    private  Integer id;
    private String user_name;
    private String password;
    private String salt;
    private Date create_time;
    private String openId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", create_time=" + create_time +
                ", openId='" + openId + '\'' +
                '}';
    }
}
