package com.ht.klinsurance.briefing.model;

import lombok.Data;

import java.util.Date;
@Data
public class BriefingLossImage {
    private String briefingLossImageId;

    private String briefingLossId;

    private String originalImage;

    private String image;

    private String description;

    private Date createTime;


}