package com.example.demo.controller;

import com.example.demo.exception.UserNotExistsException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 使用idea自动生成的springboot项目，所有的java文件都要放在com/example/demo目录下，否则会找不到页面
 * Created by Administrator on 2018/10/14.
 */

@RestController
public class QuickController {

    @RequestMapping("sayHello")
    public String sayHello(@RequestParam("user") String user){
        if(user.equals("aaa")){
            throw new UserNotExistsException();
        }
        return "Hello";
    }

    @RequestMapping("success")
    public ModelAndView success(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }



    /*@RequestMapping({"/","/login.html"})
    public ModelAndView index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }*/
}
