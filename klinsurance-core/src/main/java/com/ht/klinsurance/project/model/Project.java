package com.ht.klinsurance.project.model;

import lombok.Data;

import java.util.Date;
@Data
public class Project {

    private String   proId;

    private String projectId;

    private String userId;

    private String projectName;

    private String projectSponsor;

    private Date projectTime;

    private String insureNo;

    private String insureName;

    private String insurerId;

    private String insurerName;

    private Date accidentTime;

    private String accidentSite;

    private String accidentCause;

    private String responsibilityNo;

    private String responsibilityName;

    private String certificationCode;

    private String insureDeadline;

    private String remark;

    private Date createTime;

    private String projectNo;

    //=====================非表字段====================

    private String isReport;//报告信息

    private String isBriefing;//项目简报

  }