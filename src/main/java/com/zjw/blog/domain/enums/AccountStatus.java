package com.zjw.blog.domain.enums;

/**
 * 帐号状态.
 *
 * @author zjw
 * @create 2017-05-04  9:59
 */
public enum AccountStatus {
    DISABLED("禁用"), ENABLE("启用");
    private String cnName;

    AccountStatus(String cnName) {
        this.cnName = cnName;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }
}
