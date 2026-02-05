package com.atguigu.spring6.junit.junit4;


import com.atguigu.spring6.junit.junit5.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class SpringTestJunit4 {

//    @Autowired。不知道为啥 结合测试框架 怎么也是不好用 哎哎···
    private User user;

    @Test
    public void testUser4(){
        System.out.println(user);
        user.run();
    }
}
