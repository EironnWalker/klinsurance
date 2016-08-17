package com.ht.klinsurance.synce.bean.CRM;

import lombok.Data;

/**
 * 日程
 */
@Data
public class CRMScheduleBean
{
    private String ID;
    private String  SHEDULE_TITLE;//日程标题  !!!!!
    private String SENDER_ID;//信息发送人ID
    private String SENDER_NAME;//信息发送人
    private String PROJECT_ID;//项目
    private String  PROJECT_NAME;//项目名称    !!!!!!
    private String  CUST_ID;//客户ID
    private String   CUST_NAME;//客户名称    !!!!!
    private String  CONTACT_ID;//联系人ID
    private String CONTACT_NAME;//联系人名称
    private String  START_DATE;//开始时间   !!!!!!
    private String  END_DATE;//结束时间     !!!!!!
    private String  MAIL_FLAG;//邮件提醒标志
    private String   SMS_FLAG;//短信提醒标志
    private String   SYSMSG_FLAG;//系统消息提醒标志
    private String   MEMO;//日程内容  !!!!!!
    private String    VERSION;//版本
    private String    REAMIN_DATE;//提醒时间   !!!!!
    private String    ALLDAY_FLAG;//全天事件   !!!!!!
    private String    CREATE_DATE;//创建时间
    private String    REMIND_TYPE;//提醒方式   !!!!!!
    private String    CASE_ID;//案件ID
    private String   CASE_NAME;//案件名称
    private String   CUST_TYPE;//客户类型
    private String   IS_SYS_FLAG;//是否系统生成（1，是；0，否）
    private String   REAMIN_RATE;//循环标志（0，一次；1，持续）   !!!!!!
    private String   CANL_STATUS;//备用字段
    private String    CON_TYPE;//日程类型（1、客户；2、项目；3、案件；4、其它）     !!!!!!!!
    private String    PROJ_TYPE;//项目类型（1、潜在项目；2、正式项目）
    private String   USER_ID;//用户名称
}
