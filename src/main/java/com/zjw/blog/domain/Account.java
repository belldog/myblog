package com.zjw.blog.domain;

import com.zjw.blog.domain.enums.AccountStatus;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 帐号.
 *
 * @author belldog
 * @create 2017-05-04  9:17
 */
@Data
public class Account implements Serializable {
    /*简单来说，Java的序列化机制是通过在运行时判断类的serialVersionUID来验证版本一致性的。在进行反序列化时，
        JVM会把传来的字节流中的serialVersionUID与本地相应实体（类）的serialVersionUID进行比较，
        如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常。(InvalidCastException)*/
    private static final long serialVersionUID = 1806184724935505911L;
    private Long id;
    private String username;//用户名
    private String password;//密码
    private Integer status = AccountStatus.DISABLED.ordinal(); //状态
    private Date createDatetime;//创建时间
    private Role role;//角色
    private String token;//令牌
}
