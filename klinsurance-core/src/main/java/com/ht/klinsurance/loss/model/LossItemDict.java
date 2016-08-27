package com.ht.klinsurance.loss.model;

import lombok.Data;

import java.util.Date;
@Data
public class LossItemDict {
    private String lossItemDictId;

    private String lossItemDictPid;

    private String lossItemDictNo;

    private String name;

    private String priceUnit;

    private String numeraire;

    private String  numeraireMsg;

    private String remark;

    private Date createTime;

    private String flag;
}