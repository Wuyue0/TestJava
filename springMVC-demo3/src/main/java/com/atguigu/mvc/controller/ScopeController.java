package com.atguigu.mvc.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    // 1.通过servletApi向request域对象共享数据
    @RequestMapping("/testRequestByServletApi")
    public  String testRequestByServletApi(HttpServletRequest request){
        request.setAttribute("testRequestScope", "hello, request");
        return "success";
    }

    // 2.通过ModelAndView 向request域对象共享数据
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mav = new ModelAndView();
        // 处理模型数据
        mav.addObject("testRequestScope", "hello ModelAndView");
        mav.setViewName("success");
        return mav;
    }

    // 3.使用model向request域对象传递数据
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("testRequestScope", "hello model");
        System.out.println(model.getClass().getName());
        return "success";
    }

    // 4.使用Map向request域对象传递数据
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        map.put("testRequestScope", "hello map");
        System.out.println(map.getClass().getName());
        return "success";
    }

    // 5.使用ModelMap向request域对象共享数据
    @RequestMapping("/testModelMap")
    public  String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope", "hello modelMap");
        System.out.println(modelMap.getClass().getName());
        return "success";
    }

    //6.像session域共享数据 HttpSession
    @RequestMapping("/testSession")
    public  String testSession(HttpSession session){
        session.setAttribute("testRequestScope", "hello session");
        return "success";
    }

    //向application域共享数据
    @RequestMapping("testApplication")
    public  String testApplication(HttpSession session){
        ServletContext application = session.getServletContext();
        application.setAttribute("testRequestScope", "hello application");
        return "success";
    }

}
