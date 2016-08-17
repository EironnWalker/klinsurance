package com.ht.klinsurance.synce.bean.CRM;

import lombok.Data;

@Data
public class CRMProjcetBean {

    private String ID;
    private String  PROJECT_NUM;//项目编号  !!!!
    private String  BUSS_SRC;//业务来源   !!!!!!!
    private String  BUSS_TYPE;//业务种类   !!!1!!
    private String    BUSS_ORG;//所属业务单位 ID   !!!!
    private String   PRINCIPAL;//项目负责人
    private String    OPERATOR_ID;//操作人
    private String    NATURE;//项目性质    !1!!!!!!
    private String    START_DT;//立项时间
    private String     END_DT;//项目结束时间
    private String    NAME;//项目名称   !!!!!!
    private String    PREDICTION_COST;//项目预算
    private String    PREDICTION_INCOME;//项目预算
    private String   CONTACT_ID;//委托方
    private String   PROJECT_MEMBER;//项目成员
    private String    DESCRIPTION;//备注
    private String    REMARK;//项目概况
    private String    STATUS;//     !!!!!!!!
    private String    PREDICTION_PREMIUM;//预计保费
    private String    BUSS_ORG_NAME;//所属业务单位  !!!!!!
    private String    PRINCIPAL_NAME;//负责人名称   !!!!
    private String   OPERATOR_NAME;//操作人名称
    private String  CONTACT_NAME;// 委托方名称
    private String    ABROAD;//是否海外项目  !!!!!
    private String   CTRL_TYPE;//项目主控
    private String  CURRENCY;//币种
    private String   CREATER_ID;//创建者
    private String  CREATE_DATE;//创建时间
    private String    CREATER_NAME;//创建名
    private String    DOCKING;//对接人
    private String     PROJ_SECTOR;//项目所属行业   11!!!!!!
    private String     PROJ_CHANNEL;//项目渠道
    private String    CURRENT_NODE;//当前节点类型
    private String     CURRENT_STATUS;//当前节点状态 	CURRENT_STATUS	NUMBER(22)
    private String     PROJ_TYPE;//项目类别
    private String     RENEWAL_ID;//更新人ID
    private String     RENEWAL_TIMES;//更新时间
    private String    RENEWAL_NAME;//更新人姓名
    private String     FLOW_TYPE;//更新人姓名
    private String     PLAN_END_DT;//完成保险方案时间
    private String     BID_END_DT;//完成招标询价时间
    private String     BILL_END_DT;//完成出单时间
    private String     LOCATIONS;//
    private String     IS_FINISH;//是否续保（0，否；1，是）
    private String    CANCEL_RESULT;//项目撤销原因
    private String     FINISH_DATE;//结项日期
    private String    PROCESS_DATE;//流程日期
    private String    INSURANCE_TYPE;//公估险种
    private String    INSURANCE_TYPE_NAME;// 险种名称
    private String    INSURANCE_TYPE1;//险种备份
    private String    TB_FLAG;//招投标标志 1:没有 0：招投标完成
    private String    CREATER_UNITID;//创建单位
    private String    CREATER_DEPTID;//创建部门
    private String     AFFILIATION_ID;//
    private String   SPACECP;//
    private String   COMMISSIONDATE;//
    private String    CRM_PROJECT_ID;//
    private String   IS_DELEGATION;//是否授权
    private String    BUSS_IMPORTANT1;//业务重要程度1
    private String    BUSS_IMPORTANT2;//业务重要程度2
}
