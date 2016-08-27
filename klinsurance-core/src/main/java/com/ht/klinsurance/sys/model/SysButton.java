package com.ht.klinsurance.sys.model;

import lombok.Data;

@Data
public class SysButton {

    private String buttonId;
    private String menuCode;
    private String widgetId;
    private String widgetType;
    private String description;
    private Integer seqNum;
}