package com.boe.tww.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录拦截类
 *
 * @author 唐万万
 * @create 2018-03-13 15:08
 */
@Controller
@RequestMapping("/user")
public class IndexController {
    @GetMapping("/login_view")
    public String login_view() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}

