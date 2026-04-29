package com.atguigu.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {

    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        try{
            // 1.加载核心配置文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // 2.获取sqlSessionFactory
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            // 3.获取sqlSession 自动提交sql
            sqlSession = sqlSessionFactory.openSession(true);
        }catch (IOException e){
            e.printStackTrace();
        }
        return sqlSession;
    }
}
