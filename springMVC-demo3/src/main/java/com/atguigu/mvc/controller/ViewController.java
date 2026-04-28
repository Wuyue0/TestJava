package com.atguigu.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    // 直接请求 最终访问success视图
    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        return "success";
    }

    // 转发到请求/testThymeleafView上 然后访问success视图
    // 转发的java内部逻辑转发 格式forward:
    @RequestMapping("/testForward")
    public String testForward(){
        return "forward:/testThymeleafView";
    }

    // 重定向 我猜测应该是浏览器的跳转 格式forward:
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        return "redirect:/testThymeleafView";
    }

}
