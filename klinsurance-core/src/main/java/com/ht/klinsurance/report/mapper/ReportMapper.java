package com.ht.klinsurance.report.mapper;

import com.ht.klinsurance.report.model.Report;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportMapper {

    Report selectByPrimaryKey(String reportId);

    /**
     * 查询报告详情
     * @param reportId
     * @return
     */
    Report findDetail(String reportId);

    int addReport(Report record);

    int updateByPrimaryKeySelective(Report record);

    int deleteById(String reportId);
}