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
public class IndexController {
    @GetMapping("/user/login_view")
    public String login_view() {
        return "login";
    }

    @GetMapping("/user/index")
    public String userIndex() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "get index success";
    }

}

