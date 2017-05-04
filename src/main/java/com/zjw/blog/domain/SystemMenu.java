package com.zjw.blog.domain;

import lombok.Data;

import java.util.List;

/**
 * 系统菜单.
 *
 * @author belldog
 * @create 2017-05-04  9:56
 */
@Data
public class SystemMenu {

    private Long id;

    private String name;

    private Integer level; //菜单等级

    private SystemMenu subMenu; //上一级菜单

    private List<Permission> permissionList;

    private Integer ordinal; //在上一级菜单里的顺序
}
