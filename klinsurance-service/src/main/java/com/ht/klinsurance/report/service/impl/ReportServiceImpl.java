package com.ht.klinsurance.report.service.impl;

import com.ht.klinsurance.report.mapper.ReportBriefingMapper;
import com.ht.klinsurance.report.mapper.ReportMapper;
import com.ht.klinsurance.report.model.Report;
import com.ht.klinsurance.report.model.ReportBriefing;
import com.ht.klinsurance.report.service.IReportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ReportServiceImpl implements IReportService {

    @Resource
    private ReportMapper reportMapper;

    @Resource
    private ReportBriefingMapper reportBriefingMapper;

    /**
     * 创建报告
     *
     * @param report
     * @param reportBriefingList
     * @return
     */
    @Override
    public int creataReport(Report report, List<ReportBriefing> reportBriefingList)
    {
        //首先删除该报告的已存在内容
        int a = reportMapper.deleteById(report.getReportId());
        reportMapper.addReport(report);
        //保存ReportBriefing  也是先删除再保存
        reportBriefingMapper.deleteByReportId(report.getReportId());
        if(reportBriefingList!=null)
        {
            for(int i = 0;i<reportBriefingList.size();i++)
            {
                reportBriefingMapper.addReportBriefing(reportBriefingList.get(i));
            }
        }
        //Todo 生成报告，要先判断如果所使用的简报系统中不存在，提示他先去同步数据
        return 1;
    }
}
