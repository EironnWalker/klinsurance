package com.ht.klinsurance.user.model;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private String userId;

    private String roleId;

    private String loginName;

    private String loginPwd;

    private String name;

    private String namePinyin;

    private String company;

    private String dept;

    private String tel;

    private String mobile;

    private String remark;

    private Date createTime;

    private String email;

}