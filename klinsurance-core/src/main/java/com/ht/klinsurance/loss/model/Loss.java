package com.ht.klinsurance.loss.model;

import com.ht.klinsurance.briefing.model.BriefingLossImage;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class Loss {
    private String lossId;

    private String userId;

    private String projectId;

    private String place;

    private String placeNo;

    private String customerSignPath;

    private Date customerSignTime;

    private String customerSignPath2;
    private Date customerSignTime2;

    private String customerSignPath3;
    private Date customerSignTime3;

    private String customerSignPath4;
    private Date customerSignTime4;

    private String remark;

    private Date createTime;

    /*******************额外字段*****************************************/

    private String briefingLossId;
    private List<LossItem> lossItems;
    private List<Map<String,BriefingLossImage>> briefingLossImages;//图片信息
}