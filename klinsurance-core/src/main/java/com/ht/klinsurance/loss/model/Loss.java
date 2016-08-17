package com.ht.klinsurance.loss.model;

import com.ht.klinsurance.briefing.model.BriefingLossImage;
import lombok.Data;

import java.util.Date;
import java.util.List;

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

    /*******************额外字段*****************************************/
    private List<LossItem> lossItems;//损失项详情

    private List<List<BriefingLossImage>> briefingLossImages;//图片信息
}