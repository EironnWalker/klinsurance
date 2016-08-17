package com.ht.klinsurance.report.mapper;

import com.ht.klinsurance.report.model.ReportBriefing;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportBriefingMapper {
    int deleteByPrimaryKey(String reportBriefingId);

    int deleteByReportId(String reportId);

    int addReportBriefing(ReportBriefing record);

    ReportBriefing selectByPrimaryKey(String reportBriefingId);

    int updateByPrimaryKeySelective(ReportBriefing record);
}