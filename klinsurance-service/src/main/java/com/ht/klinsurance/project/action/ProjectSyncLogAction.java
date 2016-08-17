package com.ht.klinsurance.project.action;

import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.ht.HtMap;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.briefing.model.Briefing;
import com.ht.klinsurance.briefing.model.BriefingLoss;
import com.ht.klinsurance.briefing.model.BriefingLossImage;
import com.ht.klinsurance.briefing.model.BriefingLossItem;
import com.ht.klinsurance.common.BaseAction;
import com.ht.klinsurance.customer.model.Customer;
import com.ht.klinsurance.loss.model.Loss;
import com.ht.klinsurance.loss.model.LossItem;
import com.ht.klinsurance.project.service.IProjectSyncLogService;
import com.ht.klinsurance.report.model.Report;
import com.ht.klinsurance.report.model.ReportBriefing;
import com.ht.klinsurance.text.model.TextTemplate;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 数据同步
 * @author liuqi
 * @date 2016/7/23
 */
@Controller
@RequestMapping("projectSyncLogAction")
public class ProjectSyncLogAction extends BaseAction
{
    @Resource
    private IProjectSyncLogService projectSyncLogService;

    /**
     * 获取可同步数据信息，并将手机端未同步数据同步到手机端
     * @param userId
     * @param lastSyncTime
     * @param briefingListStr
     * @param briefingLossListStr
     * @param briefingLossImageListStr
     * @param briefingLossItemListStr
     * @param customerListStr
     * @param lossListStr
     * @param lossItemListStr
     * @param reportListStr
     * @param reportBriefingListStr
     * @param textTemplateListStr
     * @param response
     */
    @RequestMapping("getCanSyncMessage")
    public void getCanSyncMessage(String userId,String lastSyncTime,
                                  String briefingListStr,String briefingLossListStr,
                                  String briefingLossImageListStr,String briefingLossItemListStr,
                                  String customerListStr,String lossListStr,
                                  String lossItemListStr,String reportListStr,
                                  String reportBriefingListStr,String textTemplateListStr,
                                  HttpServletResponse response)
    {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date= null;
            if(StringUtils.isNotBlank(lastSyncTime))
            {
                 date = sdf.parse(lastSyncTime);
            }
            List<Briefing> briefingList = null;
            List<BriefingLoss> briefingLossList= null;
            List<BriefingLossImage> briefingLossImageList =null;
            List<BriefingLossItem> briefingLossItemList =null;
            List<Customer> customerList =null;
            List<Loss> lossList = null;
            List<LossItem> lossItemList =null;
            List<Report> reportList = null;
            List<ReportBriefing> reportBriefingList =null;
            List<TextTemplate> textTemplateList = null;
            //配装从手机端传过来的数据
            if(briefingListStr!=null)
            {
                briefingList = HtGson.fromJson(briefingListStr, new TypeToken<List<Briefing>>() { });
            }
            if(briefingLossListStr!=null)
            {
                briefingLossList = HtGson.fromJson(briefingLossListStr, new TypeToken<List<BriefingLoss>>() { });
            }
            if(briefingLossImageListStr!=null)
            {
                briefingLossImageList = HtGson.fromJson(briefingLossImageListStr, new TypeToken<List<BriefingLossImage>>() { });
            }
            if(briefingLossItemListStr!=null)
            {
                briefingLossItemList = HtGson.fromJson(briefingLossItemListStr, new TypeToken<List<BriefingLossItem>>() { });
            }
            if(customerListStr!=null)
            {
                customerList = HtGson.fromJson(customerListStr, new TypeToken<List<Customer>>() { });
            }
            if(lossListStr!=null)
            {
                lossList = HtGson.fromJson(lossListStr, new TypeToken<List<Loss>>() { });
            }
            if(lossItemListStr!=null)
            {
                lossItemList = HtGson.fromJson(lossItemListStr, new TypeToken<List<LossItem>>() { });
            }
            if(reportListStr!=null)
            {
                reportList = HtGson.fromJson(reportListStr, new TypeToken<List<Report>>() { });
            }
            if(reportBriefingListStr!=null)
            {
                reportBriefingList = HtGson.fromJson(reportBriefingListStr, new TypeToken<List<ReportBriefing>>() { });
            }
            if(textTemplateListStr!=null)
            {
                textTemplateList= HtGson.fromJson(textTemplateListStr, new TypeToken<List<TextTemplate>>() { });
            }

            HtMap resultMap = projectSyncLogService.getCanSyncMessage(userId, date,  briefingList, briefingLossList,
                     briefingLossImageList, briefingLossItemList,
                     customerList, lossList,
                     lossItemList, reportList,
                     reportBriefingList, textTemplateList);
             HtResponse.outJson(response, true, resultMap);

        } catch (Exception e) {
            log.error("数据同步方法", e);
        }
    }
}
