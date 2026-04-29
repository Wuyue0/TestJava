package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //添加用户信息 面向接口编程的两个一致
    // 1. 映射文件的namespace要和接口的全类名保持一致 2.映射文件的sql语句的id和mapper映射的方法名称保持一致

    // 1.根据用户id查找用户
    User getUserById(int id);

    //2.插入一个新用户
    int insertUser();

    //3.更新用户信息
    int updateUser();

    //4.删除用户
    int deleteUser();

    // 5.查询所有的用户list集合
    List<User> getAllUser();

    // 6.根据用户名和密码查询用户
    User checkLogin(String username, String password);

    // 7.根据map对象查询
    User checkLoginByMap(Map<String, Object> map);

    // 8.接口参数为一个实体类类型的参数
    User checkLoginByUser(User user);

    // 9.使用@param 命名参数
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);

}
