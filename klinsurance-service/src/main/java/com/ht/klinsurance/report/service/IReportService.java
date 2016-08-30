package com.ht.klinsurance.report.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.report.model.Report;
import com.ht.klinsurance.report.model.ReportBriefing;

import java.util.List;
import java.util.Map;

/**
 * 报告
 *
 * @author liuqi
 * @date 2016/7/30
 */
public interface IReportService {

    /**
     * 创建报告
     * @param report
     * @param reportBriefingList
     * @param basePath
     * @return
     */
    String  creataReport(Report report,List<ReportBriefing> reportBriefingList,String basePath);

    /**
     * 分页查询报告信息
     * @param pageBounds
     * @return
     */
    List<Report> findPageList(Map<String, Object> parameter, PageBounds pageBounds);

}
