package com.zjw.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @RequestMapping(value = "/belldog.shtml")
    public String test() {
        logger.info("belldog");
        return "belldog";
    }

    @RequestMapping(value = "/index.shtml")
    public String index() {
        logger.info("index");
        return "index";
    }

    @RequestMapping(value = "/money.shtml")
    public String money() {
        logger.info("money");
        return "money";
    }
}
