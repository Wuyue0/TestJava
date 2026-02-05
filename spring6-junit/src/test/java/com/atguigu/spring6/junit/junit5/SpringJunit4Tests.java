package com.atguigu.spring6.junit.junit5;


import com.atguigu.spring6.junit.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class SpringJunit4Tests {
    @Autowired    // 当前的测类必须放到test中否则就会报错 因为是测试框架决定的
    private User user;

    @Test
    public void testUser4(){
        System.out.println("=== Spring JUnit4 测试开始 ===");
        System.out.println(user);
        user.run();
    }
}
