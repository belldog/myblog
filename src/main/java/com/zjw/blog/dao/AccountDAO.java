package com.zjw.blog.dao;

import com.zjw.blog.base.HibaneteBaseRepository;
import com.zjw.blog.domain.Account;
import org.springframework.stereotype.Repository;

/**
 * 帐号DAO.
 *
 * @author belldog
 * @create 2017-05-04  15:53
 */
@Repository
public class AccountDAO extends HibaneteBaseRepository<Long,Account> {
}
