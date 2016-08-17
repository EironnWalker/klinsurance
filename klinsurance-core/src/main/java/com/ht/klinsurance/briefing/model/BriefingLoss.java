package com.ht.klinsurance.briefing.model;

import lombok.Data;

import java.util.Date;
@Data
public class BriefingLoss {
    private String briefingLossId;

    private String briefingId;

    private String lossId;

    private Date createTime;


}