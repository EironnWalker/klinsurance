package com.ht.klinsurance.synce.bean;

import lombok.Data;

/**
 * 同步数据时，临时使用的实体
 *
 * @author lindp
 * @date 2016/8/12
 */
@Data
public class UserBean
{
    private String USER_ID;
    private String  USERNAME;
    private String CHINESENAME;
    private String UNIT;
    private String DEPARTMENT;
    private String PERSONNEL_PHONE;
    private String PERSONNEL_MOBILE;
    private String PERSONNEL_EMAIL;
}
