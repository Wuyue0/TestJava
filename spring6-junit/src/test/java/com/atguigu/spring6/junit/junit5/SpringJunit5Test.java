package com.atguigu.spring6.junit.junit5;

import com.atguigu.spring6.junit.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(locations = "classpath:bean.xml")
public class SpringJunit5Test {

    @Autowired
    private User user;
    
    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testUser(){
        System.out.println("=== Spring JUnit5 测试开始 ===");
        
        try {
            System.out.println("ApplicationContext 类型: " + applicationContext.getClass().getName());
            System.out.println("ApplicationContext ID: " + applicationContext.getId());
            
            System.out.println("检查可用的Bean:");
            String[] beanNames = applicationContext.getBeanDefinitionNames();
            for (String beanName : beanNames) {
                System.out.println("  - " + beanName);
            }
            
            System.out.println("User对象状态: " + (user != null ? "已注入" : "未注入"));
            
            if (user != null) {
                user.run();
                System.out.println("=== 测试执行完成 ===");
            } else {
                System.out.println("User对象注入失败");
                throw new RuntimeException("User依赖注入失败");
            }
        } catch (Exception e) {
            System.err.println("测试执行异常: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}