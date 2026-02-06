package com.atguigu.advanced.pojo;

public class User {
    private String userName;
    private String pwd;

    public User(String userName, String pwd, String createdAt) {
        this.userName = userName;
        this.pwd = pwd;
        this.createdAt = createdAt;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    private String createdAt;
}
