package com.ht.klinsurance.email.service;

/**
 * 将简报和报告发送到有关人员邮箱
 */
public interface IEmailService {
    /**
     * 发送邮件
     * @param type
     * @param reportId
     * @param basePath
     * @return
     */
   int sendEmail(String type,String reportId,String basePath);
}
