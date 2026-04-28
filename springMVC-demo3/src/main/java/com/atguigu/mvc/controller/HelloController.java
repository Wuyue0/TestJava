package com.atguigu.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
//    @RequestMapping("/")
//    public String index(){
//        // 返回视图名称
//        return "index";
//    }

    @RequestMapping("/test_view")
    public String testView(){
        return "test_view";
    }

    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }

    @RequestMapping(
            value = {"/wuyue1111", "/test"},
            method = {RequestMethod.PUT, RequestMethod.POST},
            params = {"username!=admin"}
    )
    public String wuyue(){
        return "hello wrold";
    }
}
