package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisTest {
    @Test
    public void testMyBatis() throws IOException {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        // 5.获取mapper接口的对象 实际上实例化的是代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.查询所有的用户信息
        List<User> list = userMapper.getAllUser();
        for (User user : list){
            System.out.println(user);
        }
        // 7.根据用户的id查询用户信息
        User result = userMapper.getUserById(1);
        System.out.println("getUserById结果为: " + result);

        // 8.插入一个新用户
        //int result1 = userMapper.insertUser();
        //System.out.println(result1);

        // 9.修改用户信息
        // int result2 = userMapper.updateUser();
        // System.out.println("结果为: " + result2);

        // 10.删除用户信息
        // int result3 = userMapper.deleteUser();
        // System.out.println("结果为: " + result3);

        // 11.验证登录
        User user = userMapper.checkLogin("zhangsan", "123456");
        System.out.println("checkLogin结果为: " + user);

        // 12. checkLoginByMap 使用map集合封装参数
        Map<String, Object> map = new HashMap<>();
        map.put("username", "zhangsan");
        map.put("password", "123456");
        User user1 = userMapper.checkLoginByMap(map);
        System.out.println("checkLoginByMap结果为: " + user1);

        // 13.checkLoginByUser
        User user2 = new User("zhangsan",null,  "123456", null);
        User user3 = userMapper.checkLoginByUser(user2);
        System.out.println("checkLoginByUser结果为: " + user3);

        // 14.checkLoginByParam
        User user4 = userMapper.checkLoginByParam("zhangsan", "123456");
        System.out.println("checkLoginByParam结果为: " + user4);

    }



    //mybatis 获取参数值的两种方式 ${} 本质字符串拼接 和 #{} 本质占位符赋值
    //mybatis 获取参数值的各种情况
    @Test
    public void testJDBC() throws IOException {

        ArrayList<String> list = new ArrayList<>();
    }
}
