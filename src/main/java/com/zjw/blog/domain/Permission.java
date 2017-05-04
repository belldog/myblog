package com.zjw.blog.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 权限.
 *
 * @author belldog
 * @create 2017-05-04  10:34
 */
@Data
public class Permission implements Serializable {

    private Long id;

    private String name;

    private String code;
}
