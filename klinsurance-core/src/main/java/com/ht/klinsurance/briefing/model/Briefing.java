package com.ht.klinsurance.briefing.model;

import lombok.Data;

import java.util.Date;
@Data
public class Briefing {
    private String briefingId;

    private String briefingNo;

    private String userId;

    private String projectId;

    private String wordTemplateId;

    private Date surveyTime;

    private String surveyPlace;

    private  String  surveyLat;

    private  String surveyLng;

    private String insurer;

    private String insurerName;

    private String insurerPhone;

    private String surveyor;

    private String accidentDescription;

    private String lossDescription;

    private String nextWork;

    private String mainSurveyor;

    private String subSurveyor;

    private String manager;

    private String briefingFile;

    private String remark;

    private Date createTime;

    /*******************************************************/
    private String projectName; //项目名字

    private String subSurveyName; //协助公估师

    private String downloadFile; //下载Word地址

}