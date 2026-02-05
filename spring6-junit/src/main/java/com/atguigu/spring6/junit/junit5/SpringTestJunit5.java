package com.atguigu.spring6.junit.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:bean.xml")
public class SpringTestJunit5 {

    @Autowired
    private User user;


    @Test
    public void testUser(){
//        user.run();
//        new ClassPathXmlApplicationContext("classpath:spring6-junit5-context.xml");
    }
}
