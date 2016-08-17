package com.ht.klinsurance.word.model;

import lombok.Data;

import java.util.Date;
@Data
public class WordTemplate {
    private String wordTemplateId;

    private String name;

    private String type;

    private String filePath;

    private String remark;

    private Date createTime;

}