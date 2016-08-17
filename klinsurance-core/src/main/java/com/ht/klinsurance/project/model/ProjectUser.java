package com.ht.klinsurance.project.model;

import lombok.Data;

import java.util.Date;
@Data
public class ProjectUser {
    private String projectUserId;

    private String userId;

    private String projectId;

    private String userName;

    private String chineseName;

    private String duty;

    private String certificateNo;

    private Date createTime;

}