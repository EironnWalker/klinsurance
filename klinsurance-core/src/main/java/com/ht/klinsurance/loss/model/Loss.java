package com.ht.klinsurance.loss.model;

import lombok.Data;

import java.util.Date;
@Data
public class Loss {
    private String lossId;

    private String userId;

    private String projectId;

    private String place;

    private String placeNo;

    private String customerSignPath;

    private Date customerSignTime;

    private String remark;

    private Date createTime;


}