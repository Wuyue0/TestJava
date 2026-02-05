package com.atguigu;

import com.atguigu.bean.AnnotationApplicationContext;
import com.atguigu.bean.ApplicationContext;
import com.atguigu.service.UserService;
import org.junit.jupiter.api.Test;

public class TestUser {
    
    @Test
    public void test()  {
        try{
            // 创建spring容器
            ApplicationContext context = new AnnotationApplicationContext("com.atguigu");
            // 从容器获取bean
            UserService userService = (UserService) context.getBean(UserService.class);
            System.out.println(userService);
            userService.add();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
