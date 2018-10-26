package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 登录Controller
 * 用户名非空且密码为123456即可登录，登录成功后重定向到main.html页面
 * @author hujtb
 * @create on 2018-10-22-16:28
 */

@Controller
public class LoginController {

    @PostMapping(value="/user/login")
    //@RequestMapping(value="/user/login", method= RequestMethod.POST)
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session){
        session.setAttribute("loginUserName", username);
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            return "redirect:/main.html";
        }else{
            map.put("msg", "请检查用户名密码~");
            return "login";
        }
    }
}
