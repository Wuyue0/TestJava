package com.atguigu.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {


    // 查询所有的用户信息
    //@RequestMapping(value = "/user", method = RequestMethod.GET)
    @GetMapping("/users")
    public String getAllUsers(){
        System.out.println("查询所有的用户信息");
        return  "success";
    }

    // 根据用户的id查询用户信息
    @GetMapping("/user/{id}")
    public String getUserById(String id){
        System.out.println("根据用户id查询用户信息");
        return  "success";
    }


    // 创建用户信息
    @PostMapping("/user")
    public String insertUser(String username, String password){
        System.out.println("添加用户信息"+username+','+password);
        return "success";
    }

    // 修改用户信息
    @PutMapping("/user")
    public String updateUser(String username, String password){
        System.out.println("修改用户信息"+username+','+password);
        return "success";
    }


    // 1、@ReauestBody
    // 2、@ResponseBody
}
