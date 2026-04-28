package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
        // 5.获取mapper接口的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.测试功能
        int result = userMapper.insertUser();

        System.out.println("结果为: " + result);
    }
}
