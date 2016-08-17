package com.ht.klinsurance.synce.bean.CRM;

import lombok.Data;

/**
 * 交互记录管理
 */
@Data
public class CRMInteractiveNoteBean
{
   private String  ID;
    private String   RECEIVE_ID;//指派人表ID
    private String  TRAN_TYPE;//无联系为0
    private String  CREATE_DATE;//创建时间   !!!!!
    private String  CUST_MOD_FLAG;//客户信息是否变更（1为是，0为否）
    private String  CONTACT_MOD_FLAG;//联系人信息是否变更（1为是，0为否）
    private String    MEMO;//备注  !!!!!
    private String VERSION;//版本
    private String  TRAN_DATE;//流转日起
    private String   PROJECT_ID;//项目ID
    private String  PROJECT_NAME;//项目名称
    private String  CUST_ID;//客户ID
    private String  CUST_NAME;//客户姓名    !!!!!
    private String   CONTACT_ID;//联系人ID
    private String    CONTACT_NAME;//联系人姓名  !!!!!
    private String    CASE_ID;//案件ID
    private String   CASE_NAME;//案件名称
    private String    CREATE_NAME;//创建人姓名
    private String    CUR_CUST_ST;//当前客户状态
    private String     CUR_PROJECT_ST;//当前项目状态
    private String     CUR_CONTACT_ST;//当前案件状态
    private String     NEXT_CON_DATE;//下一次联系时间约定
    private String     COMPANY_IN;//本公司参与人   !!!!!
    private String     CONTACT_IN;//客户参与人  !!!!!
    private String  CON_TYPE;//联系方式，1客户，2项目，3案件，
    private String  PRIMSEC_ID;//
    private String   PROJ_PROG;//潜在项目进度标识
    private String   PROJ_TAST;//潜在项目活动类型	PROJ_TAST	CHAR(1)
    private String   CASE_PROG;//案件进度标识	CASE_PROG	CHAR(1)
    private String   CASE_TAST;//案件活动类型
    private String   PRE_CUST_TAST;//潜在客户活动类型
    private String  OTHER_TAST;//正式客户和正式项目活动类型
    private String  PREORPROJ;//正式项目和潜在项目标志
    private String  PREORCUST;//正式客户和潜在客户标志
    private String  ADDRESS;//地点    !!!!!
    private String  CUST_DEPT;//客户部门或所属单位  !!!!!
    private String  TRAIN_TITLE;//培训主题
    private String  PROBLEM;//解决问题
    private String  OFFER_VALID;//有效报价内容
    private String  CASE_TAST_NAME;//案件活动类型名称串
    private String  MAIL_NAME;//邮件主题串
    private String MAIL_ID;//邮件ＩＤ串
    private String OPERATOR_CODE;//操作人编号
    private String  OPERATOR_NAME;//操作人姓名
    private String   OPERATOR_DATE;//操作时间
    private String    BELONGS_ID;//归属部门(单位)ID
    private String    BELONGS_DEPT;//归属机构
    private String     BELONGS_DEPT_ID;//归属机构ID
    private String    BELONGS;//归属部门(单位)
    private String     PROJ_TYPE;//1表示售前项目2表示正式项目
    private String   CUST_TYPE;//1表示潜在客户2表示正式客户
    private String   COMPANY_IN_CODE;//
}
