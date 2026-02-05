package com.atguigu.spring6.junit.junit5;

import com.atguigu.spring6.junit.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleSpringTest {

    @Test
    public void testSpringContextLoad() {
        System.out.println("开始测试Spring上下文加载...");
        
        try {
            // 直接手动加载Spring上下文
            ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
            System.out.println("Spring上下文加载成功");
            
            // 尝试获取Bean
            User user = context.getBean(User.class);
            System.out.println("成功获取User Bean");
            user.run();

        } catch (Exception e) {
            System.err.println("Spring上下文加载失败: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}