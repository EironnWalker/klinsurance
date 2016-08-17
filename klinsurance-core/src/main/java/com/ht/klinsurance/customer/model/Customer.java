package com.ht.klinsurance.customer.model;

import lombok.Data;

import java.util.Date;
@Data
public class Customer {
    private String customerId;

    private String name;

    private String linkMan;

    private String linkManPinyin;

    private String linkPhone;

    private String province;

    private String city;

    private String county;

    private String address;

    private String remark;

    private Date createTime;

    private String superiorId;
    private String superior;
    private String classification;
}