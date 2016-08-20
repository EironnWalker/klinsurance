package com.ht.klinsurance.report.service;

/**
 * @author feicy
 * @date 2016/8/19
 */
public interface IBuildReportService {
    /**
     * 生成报告
     * @param webPath
     * @param reportId
     * @return
     * @throws Exception
     */
    String buildReport(String webPath,String reportId) throws Exception;
}
