package com.ht.klinsurance.appVersion.model;

import lombok.Data;

import java.util.Date;

@Data
public class AppVersion {
    private String appVersionId;

    private String appType;

    private String appVersion;

    private String appAndroidUrl;

    private String appIosUrl;

    private Boolean isClosed;

    private Date createTime;

    private String remark;


}