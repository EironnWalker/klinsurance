package com.ht.klinsurance.report.model;

import lombok.Data;

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

    private String insureAmount;

    private String deductible;

    private Date accidentTime;

    private String accidentPlace;

    private String accidentCause;

    private String accidentPass;

    private String liabilityAffirm;

    private String reportedLossAmount;

    private String verifyLossAmount;

    private String adjustmentAmount;

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
}