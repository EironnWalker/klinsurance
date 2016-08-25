package com.ht.klinsurance.sys.model;

import lombok.Data;

/**
 * 系统菜单
 */
@Data
public class SysMenu{

    private String menuId;      // 菜单ID
    private String menuCode;    // 菜单编码
    private String menuPcode;   // 菜单父编码
    private String name;        // 菜单名
    private String url;         // 菜单URl
    private String icon;        // 菜单图标
    private Integer seqNum;     // 排序号
    private Boolean isShow;     // 是否显示
}