package com.zjw.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试控制器.
 *
 * @author belldog
 * @create 2017-04-14  9:26
 */
@Controller
public class TestController  {
    @RequestMapping(value="/hello.shtml")
    public String test(){
        return "hello";
    }
    @RequestMapping(value="/index.shtml")
    public String index(){
        return "index";
    }
}
