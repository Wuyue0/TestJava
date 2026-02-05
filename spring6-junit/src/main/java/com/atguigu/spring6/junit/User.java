package com.atguigu.spring6.junit;

import org.springframework.stereotype.Component;

@Component("userBean")
public class User {
    
    public User() {
        System.out.println("User构造函数被调用");
    }
    
    public void run(){
        System.out.println("user run method executed......");
    }
}
