package com.ht.klinsurance.user.model;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private String userId;

    private String loginName;

    private String loginPwd;

    private String roleId;

    private String name;

    private String namePinyin;

    private String company;

    private String dept;

    private String tel;

    private String mobile;

    private String remark;

    private Date createTime;

    private String email;

    private String isUsed;

    private String userType;

    ///////////////////********临时字段用于判断saveorupdate*****////////////////////
    private Integer count;

}