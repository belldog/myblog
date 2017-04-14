package com.zjw.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试控制器.
 *
 * @author belldog
 * @create 2017-04-14  9:26
 */
@Controller
public class TestController {
    @RequestMapping(value = "/belldog.shtml")
    public String test() {
        return "belldog";
    }

    @RequestMapping(value = "/index.shtml")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/money.shtml")
    public String money() {
        return "money";
    }
}
