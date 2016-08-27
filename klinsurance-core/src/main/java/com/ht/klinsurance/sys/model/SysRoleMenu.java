package com.ht.klinsurance.sys.model;

import lombok.Data;

@Data
public class SysRoleMenu {

    private String roleMenuId;
    private String roleId;
    private String menuCode;

    /*================================== 自定义字段 ==================================*/

    private String id;
    private String pId;
    private String name;
    private Boolean checked;
    private Boolean isParent;
    private Boolean open;
    private Integer seqNum;
}