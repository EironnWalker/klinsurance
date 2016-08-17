package com.ht.klinsurance.briefing.model;

import lombok.Data;

import java.util.Date;
@Data
public class BriefingLossItem {
    private String briefingLossItemId;

    private String briefingLossId;

    private String lossItemId;

    private Date createTime;

}