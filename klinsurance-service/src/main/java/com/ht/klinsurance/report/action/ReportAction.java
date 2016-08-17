package com.ht.klinsurance.report.action;

import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.common.BaseAction;
import com.ht.klinsurance.report.model.Report;
import com.ht.klinsurance.report.model.ReportBriefing;
import com.ht.klinsurance.report.service.IReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 报告
 * @author liuqi
 * @date 2016/7/30
 */
@Controller
@RequestMapping("reportAction")
public class ReportAction extends BaseAction
{
    @Resource
    private IReportService reportService;

    /**
     * 生成报告
     * @param reportJson
     * @param reportBriefingJson
     * @param response
     */
    @RequestMapping("addReport")
    public void addReport(String reportJson,String reportBriefingJson, HttpServletResponse response)
    {
        try {

            Report report =  HtGson.fromJson(reportJson, new TypeToken<Report>() {
            });
            List<ReportBriefing> reportBriefingList =  HtGson.fromJson(reportBriefingJson, new TypeToken<List<ReportBriefing>>() {
            });
            int  result = reportService.creataReport(report, reportBriefingList);
            if (result>0) {
                HtResponse.outJson(response, true, null);
            } else {
                HtResponse.outJson(response, false, null);
            }
        } catch (Exception e) {
            log.error("添加报告", e);
        }
    }
}
