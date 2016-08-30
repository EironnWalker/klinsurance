package com.ht.klinsurance.report.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.report.model.Report;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ReportMapper {

    /**
     * 分页查询报告信息
     * @param pageBounds
     * @return
     */
    List<Report> findPageList(Map<String, Object> parameter, PageBounds pageBounds);


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