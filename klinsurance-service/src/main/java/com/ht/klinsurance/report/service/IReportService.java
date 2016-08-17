package com.ht.klinsurance.report.service;

import com.ht.klinsurance.report.model.Report;
import com.ht.klinsurance.report.model.ReportBriefing;

import java.util.List;

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
     * @return
     */
    int creataReport(Report report,List<ReportBriefing> reportBriefingList);
}
