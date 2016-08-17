package com.ht.klinsurance.project.model;

import lombok.Data;

import java.util.Date;
@Data
public class ProjectSyncLog {
    private String projectSyncLogId;

    private String projectId;

    private String projectName;

    private String content;

    private Boolean isSuccess;

    private Date createTime;

}