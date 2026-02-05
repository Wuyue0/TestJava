package com.atguigu.spring6.junit.junit5;

import com.atguigu.spring6.junit.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ManualSpringTest {

    @Test
    public void testManualSpringSetup() {
        System.out.println("=== 手动Spring测试开始 ===");
        try {
            System.out.println("1. 创建Spring应用上下文...");
            ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
            System.out.println("2. 上下文创建成功，检查Bean...");
            
            // 检查所有Bean定义
            String[] beanNames = context.getBeanDefinitionNames();
            System.out.println("已定义的Bean数量: " + beanNames.length);
            for (String beanName : beanNames) {
                System.out.println("  - " + beanName + ": " + context.getBean(beanName).getClass().getName());
            }
            
            System.out.println("3. 尝试获取User Bean...");
            User user = context.getBean("userBean", User.class);
            
            if (user != null) {
                System.out.println("4. 成功获取User Bean，执行方法...");
                user.run();
                System.out.println("=== 测试成功完成 ===");
            } else {
                System.out.println("4. 未能获取User Bean");
                throw new RuntimeException("User Bean不存在");
            }
            
        } catch (Exception e) {
            System.err.println("=== 测试失败 ===");
            System.err.println("错误类型: " + e.getClass().getSimpleName());
            System.err.println("错误信息: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("手动Spring测试失败", e);
        }
    }
}