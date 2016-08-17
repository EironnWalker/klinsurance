package com.ht.klinsurance.loss.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class LossItem {
    private String lossItemId;

    private String projectId;

    private String lossId;

    private String lossItemName;

    private Integer lossNumber;

    private BigDecimal length;

    private BigDecimal width;

    private BigDecimal height;

    private BigDecimal price;

    private BigDecimal realLossAmount;

    private BigDecimal reportedLossAmount;

    private String remark;

    private Date createTime;

    ///////////////临时字段////////////////////////

    private String projectName;

    private String lossPlace;
}