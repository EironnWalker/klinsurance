package com.ht.klinsurance.text.model;

import lombok.Data;

import java.util.Date;
@Data
public class TextTemplate {

    private String textTemplateId;

    private String name;

    private String content;

    private String tags;

    private Date createTime;

    private Boolean isShared;

    //===============标签名字===============
    private String tagName;

}