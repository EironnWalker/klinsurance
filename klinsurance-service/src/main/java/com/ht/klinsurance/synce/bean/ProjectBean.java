package com.ht.klinsurance.synce.bean;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectBean {
    private String ID;
    private String PROJECT_NUM;
    private String NAME;
    private String  OPERATOR_NAME;
    private Date START_DT;
    private String  INSURANCE_TYPE_NAME;
    private String  INSURANCE_TYPE;
    private String INSURED_NAME;
    private String  INSURED;
    private Date ACCIDENT_TIME;
    private String   ACCIDENTPLACE;
    private String   CASE_REASON_VALUE;
    private  String DUTY_CERTIFY_NAME;
    private String DUTY_CERTIFY_CODE;
    private String QUALIFICATION_CODE;
    private String INSURANCE_TERM;
}
