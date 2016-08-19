package com.ht.klinsurance.report.mapper;

import com.ht.klinsurance.report.model.ReportBriefing;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportBriefingMapper {

    ReportBriefing selectByPrimaryKey(String reportBriefingId);

    /**
     * 根据报告查询简报信息
     * @param reportId
     * @return
     */
    List<ReportBriefing> findByReport(String reportId);

    int addReportBriefing(ReportBriefing record);

    int updateByPrimaryKeySelective(ReportBriefing record);

    int deleteByPrimaryKey(String reportBriefingId);

    int deleteByReportId(String reportId);
}