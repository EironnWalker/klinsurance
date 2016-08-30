package com.ht.klinsurance.report.action;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.ht.HtMap;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.common.BaseAction;
import com.ht.klinsurance.common.KlConsts;
import com.ht.klinsurance.report.model.Report;
import com.ht.klinsurance.report.model.ReportBriefing;
import com.ht.klinsurance.report.service.IReportService;
import org.apache.commons.lang.StringUtils;
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
            String path=request.getSession().getServletContext().getRealPath("/");
            String  ftpUrl = reportService.creataReport(report, reportBriefingList,path);


            if (ftpUrl!=null) {
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
            //String path=request.getSession().getServletContext().getRealPath("/");
            //String ftpUrl=buildReportService.buildReport(path,"12d22584dd074f48846b7b477b204643");
            //System.out.println("ftpUrl：" + ftpUrl);
        } catch (Exception e) {
            log.error("生成报告",e);
        }
    }

    /**
     * 分页查看项目报告信息
     */
    @RequestMapping("findReportPageList")
    public void findReportPageList(String projectId,Integer limit,Integer pageNo, HttpServletResponse response){
        try {
            limit = limit == null ? KlConsts.PAGE_LIMIT : limit;
            HtMap htMap = new HtMap();
            if(StringUtils.isNotBlank(projectId)){
                htMap.put("projectId",projectId);
            }
            PageList<Report> textTemplateList = (PageList<Report>)reportService
                    .findPageList(htMap, new PageBounds(pageNo, limit));
            HtResponse.outPageJson(response, true, textTemplateList);
        } catch (Exception e) {
            log.error("显示项目信息列表主方法", e);
        }
    }

}
