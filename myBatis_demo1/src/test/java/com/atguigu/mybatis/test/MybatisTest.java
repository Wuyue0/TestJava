package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {



    @Test
    public void testMyBatis() throws IOException {
        // 1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2.获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 3.获取sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 4.获取sqlSession 自动提交sql
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 5.获取mapper接口的对象 实际上实例化的是代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.查询所有的用户信息
        List<User> list = userMapper.getAllUser();
        for (User user : list){
            System.out.println(user);
        }
        // 7.根据用户的id查询用户信息
        User result = userMapper.getUserById();
        System.out.println("结果为: " + result);

        // 8.插入一个新用户
        //int result1 = userMapper.insertUser();
        //System.out.println(result1);

        // 9.修改用户信息
        // int result2 = userMapper.updateUser();
        // System.out.println("结果为: " + result2);

        // 10.删除用户信息
        // int result3 = userMapper.deleteUser();
        // System.out.println("结果为: " + result3);
    }
}
