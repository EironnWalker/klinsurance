package com.ht.klinsurance.report.mapper;

import com.ht.klinsurance.report.model.Report;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportMapper {
    int deleteById(String reportId);

    int addReport(Report record);

    Report selectByPrimaryKey(String reportId);

    int updateByPrimaryKeySelective(Report record);

}