package com.atguigu.mybatis.pojo;

public class User {
    private int id;
    private String username;
    private String password;
    private String created_at;

    public User() {
    }

    public User(String username, Integer id, String password, String created_at) {
        this.username = username;
        this.id = id;
        this.password = password;
        this.created_at = created_at;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
