package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface DynamicSQLMapper {


    List<User> getUserByCondition(User user);
}
