package com.ht.klinsurance.project.service;

import com.ht.common.ht.HtMap;
import com.ht.klinsurance.briefing.model.Briefing;
import com.ht.klinsurance.briefing.model.BriefingLoss;
import com.ht.klinsurance.briefing.model.BriefingLossImage;
import com.ht.klinsurance.briefing.model.BriefingLossItem;
import com.ht.klinsurance.customer.model.Customer;
import com.ht.klinsurance.loss.model.Loss;
import com.ht.klinsurance.loss.model.LossItem;
import com.ht.klinsurance.report.model.Report;
import com.ht.klinsurance.report.model.ReportBriefing;
import com.ht.klinsurance.text.model.TextTemplate;

import java.util.Date;
import java.util.List;

/**
 * 项目同步记录信息
 *
 * @author liuqi
 * @date 2016/7/22
 */
public interface IProjectSyncLogService
{
    /**
     *
     * @param userId
     * @param updateTime
     * @param briefingListPh
     * @param briefingLossListPh
     * @param briefingLossImageListPh
     * @param briefingLossItemListPh
     * @param customerListPh
     * @param lossListPh
     * @param lossItemListPh
     * @param reportListPh
     * @param reportBriefingListPh
     * @param textTemplateList
     * @return
     */
    HtMap getCanSyncMessage(String userId , Date updateTime, List<Briefing> briefingListPh,
            List<BriefingLoss> briefingLossListPh,
            List<BriefingLossImage> briefingLossImageListPh ,
            List<BriefingLossItem> briefingLossItemListPh ,
            List<Customer> customerListPh,
            List<Loss> lossListPh,
            List<LossItem> lossItemListPh,
            List<Report> reportListPh,
            List<ReportBriefing> reportBriefingListPh,
            List<TextTemplate> textTemplateList);
}
