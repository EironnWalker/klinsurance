package com.ht.klinsurance.report.action;

import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.common.BaseAction;
import com.ht.klinsurance.report.model.Report;
import com.ht.klinsurance.report.model.ReportBriefing;
import com.ht.klinsurance.report.service.IBuildReportService;
import com.ht.klinsurance.report.service.IReportService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    @Resource
    private IBuildReportService buildReportService;

    /**
     * 生成报告
     * @param reportJson
     * @param reportBriefingJson
     * @param response
     */
    @RequestMapping("addReport")
    public void addReport(String reportJson,String reportBriefingJson, HttpServletResponse response,HttpServletRequest request)
    {
        try {

            Report report =  HtGson.fromJson(reportJson, new TypeToken<Report>() {
            });
            List<ReportBriefing> reportBriefingList =  HtGson.fromJson(reportBriefingJson, new TypeToken<List<ReportBriefing>>() {
            });
            int  result = reportService.creataReport(report, reportBriefingList);
            String path=request.getSession().getServletContext().getRealPath("/");
            String ftpUrl=buildReportService.buildReport(path,report.getReportId());
            if (result>0) {
                HtResponse.outJson(response, true, ftpUrl);
            } else {
                HtResponse.outJson(response, false, null);
            }
        } catch (Exception e) {
            log.error("添加报告", e);
        }
    }

    /**
     * 生成报告
     * @param request
     */
    @RequestMapping("test")
    public void test(HttpServletRequest request){
        try {
            String path=request.getSession().getServletContext().getRealPath("/");
            String ftpUrl=buildReportService.buildReport(path,"12d22584dd074f48846b7b477b204643");
            System.out.println("ftpUrl：" + ftpUrl);
        } catch (Exception e) {
            log.error("生成报告",e);
        }
    }
}
