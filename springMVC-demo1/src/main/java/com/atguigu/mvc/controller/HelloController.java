package com.atguigu.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    // "/" => /WEB-INF/templates/index.html
    @RequestMapping("/")
    public String index(){
        // 返回视图名称
        return "index";
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

    //    @PostMapping
    //
    //    @GetMapping
    //
    //    @PostMapping
    //
    //    @DeleteMapping
}
