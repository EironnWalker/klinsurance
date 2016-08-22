package com.ht.klinsurance.synce;

import com.ht.klinsurance.synce.bean.CRM.CRMInteractiveNoteBean;

/**
 * @author lindp
 * @date 2016/8/17
 */
public interface ICRMSynceDataService
{
    /**
     * 交互记录
     * @return
     */
    int synceInteractiveNote(String userId);

    /**
     * 增加交互记录
     * @param crmInteractiveNoteBean
     * @return
     */
    int addInteractiveNote(CRMInteractiveNoteBean crmInteractiveNoteBean);

    /**
     * 项目
     * @param userId
     * @return
     */
    int synceProjcet(String userId);

    /**
     * 日程
     * @return
     */
    int synceScheduleBean(String userId);
}
