package com.atguigu.mybatis.mapper;

public interface UserMapper {
    //添加用户信息 面向接口编程的两个一致
    // 1. 映射文件的namespace要和接口的全类名保持一致 2.映射文件的sql语句的id和mapper映射的方法名称保持一致
    int insertUser();
}
