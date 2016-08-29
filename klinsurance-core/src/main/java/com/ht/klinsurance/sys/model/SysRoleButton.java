package com.ht.klinsurance.sys.model;

import lombok.Data;

@Data
public class SysRoleButton {

    private String roleButtonId;
    private String roleId;
    private String buttonId;
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