package com.ht.klinsurance.report.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
@Data
public class Report {
    private String reportId;

    private String reportNo;

    private String userId;

    private String projectId;

    private String wordTemplateId;

    private String insureType;

    private String insureCode;

    private String insurer;

    private String insurerName;

    private String insureDeadline;

    private BigDecimal insureAmount;

    private String deductible;

    private Date accidentTime;

    private String accidentPlace;

    private String accidentCause;

    private String accidentPass;

    private String liabilityAffirm;

    private BigDecimal reportedLossAmount;

    private BigDecimal verifyLossAmount;

    private BigDecimal adjustmentAmount;

    private String surveyor;

    private String certificateCode;

    private String forewordContent;

    private String objectDescription;

    private Date surveyTime;

    private String surveyPlace;

    private String surveyCase;

    private String insurerRepresentative;

    private String surveySurveyor;

    private String claimantDescription;

    private Date dangerTime;

    private String dangerPlace;

    private String damagedObject;

    private String dangerCase;

    private String iorderLiability;

    private String verifyLossGist;

    private String verifyLossProcess;

    private String repeatInsure;

    private String thirdLiability;

    private String deductibleSalvage;

    private String lossAdjustment;

    private String surveyorConclusion;

    private String reportFile;

    private String remark;

    private Date createTime;

    /**************************************************/
    private String projectName;//项目名

    private String insurerAddress;//被保险人地址

    private String insLinkMan;//被保险人联系人

    private String insLinkPhone;//被保险人联系电话
    private String surName;//公估人名字
    private String surPhone;//公估人电话
    private String surTel;//公估人传真
}