package com.ht.klinsurance.email.action;

import com.ht.common.http.HtResponse;
import com.ht.klinsurance.common.BaseAction;
import com.ht.klinsurance.email.service.IEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 将简报和报告发送到指定邮箱
 *
 * @author lindp
 * @date 2016/8/28
 */
@Controller
@RequestMapping("emailAction")
public class EmailAction extends BaseAction
{
    @Resource
    private IEmailService emailService;
    @RequestMapping("sendEmail")
    public void sendEmail(String type,String reportId,HttpServletResponse response,HttpServletRequest request)
    {
        try {
            String basePath = request.getSession().getServletContext().getRealPath("/")+"/";
            int result = emailService.sendEmail(type,reportId,basePath);
            if(result==1)
            {
                HtResponse.outJson(response, true, "邮件发送成功");
            }else if(result==-1)
            {
                HtResponse.outJson(response, false, "报告尚未生成");
            }else if(result==-2)
            {
                HtResponse.outJson(response, false, "接受邮箱未设置");
            }else if (result==-6){
                HtResponse.outJson(response, false, "邮件发送异常");
            }else{
                HtResponse.outJson(response, false, "邮件发送异常");
            }
        }catch (Exception e)
        {
            HtResponse.outJson(response, false, "邮件发送异常");
            log.error(e);
        }
    }
}
