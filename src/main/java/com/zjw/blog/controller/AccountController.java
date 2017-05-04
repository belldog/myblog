package com.zjw.blog.controller;

import com.zjw.blog.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 帐号控制器.
 *
 * @author belldog
 * @create 2017-05-04  16:30
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
}
