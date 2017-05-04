package com.zjw.blog.service;

import com.zjw.blog.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 帐号Service.
 *
 * @author belldog
 * @create 2017-05-04  16:29
 */
@Service
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;
}
