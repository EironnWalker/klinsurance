package com.ht.klinsurance.report.model;

import lombok.Data;

import java.util.Date;
@Data
public class ReportBriefing {
    private String reportBriefingId;

    private String reportId;

    private String briefingId;

    private Date createTime;
}