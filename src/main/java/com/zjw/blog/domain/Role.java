package com.zjw.blog.domain;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * 角色.
 *
 * @author belldog
 * @create 2017-05-04  9:31
 */
@Data
public class Role {

    private Long id;

    private String name;

    private String code;

    private Set<Permission> permissions = new HashSet<>();
}
