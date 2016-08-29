package com.ht.klinsurance.email.service.impl;

import com.ht.klinsurance.briefing.mapper.BriefingMapper;
import com.ht.klinsurance.briefing.model.Briefing;
import com.ht.klinsurance.email.service.IEmailService;
import com.ht.klinsurance.report.mapper.ReportMapper;
import com.ht.klinsurance.report.model.Report;
import com.ht.klinsurance.user.mapper.UserMapper;
import com.ht.klinsurance.user.model.User;
import com.ht.klinsurance.utils.email.EmailUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class EmailServiceImpl implements IEmailService {
    @Resource
    private BriefingMapper briefingMapper;
    @Resource
    private UserMapper userMapper;

    @Resource
    private ReportMapper reportMapper;
    /**
     * 发送邮件
     *
     * @param type
     * @param reportId
     * @param basePath
     * @return
     */
    @Override
    public int sendEmail(String type, String reportId,String basePath)
    {
        if(type.equals("1"))//简报
        {
           Briefing briefing =  briefingMapper.findDetailInfo(reportId);
            if(briefing==null|| StringUtils.isEmpty(briefing.getBriefingFile()))
            {
                return -1;
            }
            User user = userMapper.selectByPrimaryKey(briefing.getUserId());
            if(user!=null&&StringUtils.isNotEmpty(user.getEmail()))
            {
                int result = EmailUtils.sendMail(briefing.getProjectName()+"简报",user.getEmail(),"","",basePath+briefing.getBriefingFile());
                return result;
            }else {
                return -2;
            }

        }else//报告
        {
            Report report = reportMapper.findDetail(reportId);
            if(report==null|| StringUtils.isEmpty(report.getReportFile()))
            {
                return -1;
            }
            User user = userMapper.selectByPrimaryKey(report.getUserId());
            if(user!=null&&StringUtils.isNotEmpty(user.getEmail()))
            {
                int result = EmailUtils.sendMail(report.getProjectName()+"报告",user.getEmail(),"","",basePath+report.getReportFile());
                return result;
            }else {
                return -2;
            }
        }
    }
}
