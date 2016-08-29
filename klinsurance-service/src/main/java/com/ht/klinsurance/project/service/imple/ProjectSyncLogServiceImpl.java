package com.ht.klinsurance.project.service.imple;


import com.ht.common.gson.HtGson;
import com.ht.common.ht.HtMap;
import com.ht.common.utils.UUIDGenerate;
import com.ht.klinsurance.briefing.mapper.BriefingLossImageMapper;
import com.ht.klinsurance.briefing.mapper.BriefingLossItemMapper;
import com.ht.klinsurance.briefing.mapper.BriefingLossMapper;
import com.ht.klinsurance.briefing.mapper.BriefingMapper;
import com.ht.klinsurance.briefing.model.Briefing;
import com.ht.klinsurance.briefing.model.BriefingLoss;
import com.ht.klinsurance.briefing.model.BriefingLossImage;
import com.ht.klinsurance.briefing.model.BriefingLossItem;
import com.ht.klinsurance.customer.mapper.CustomerMapper;
import com.ht.klinsurance.customer.model.Customer;
import com.ht.klinsurance.loss.mapper.LossItemDictMapper;
import com.ht.klinsurance.loss.mapper.LossItemMapper;
import com.ht.klinsurance.loss.mapper.LossMapper;
import com.ht.klinsurance.loss.model.Loss;
import com.ht.klinsurance.loss.model.LossItem;
import com.ht.klinsurance.loss.model.LossItemDict;
import com.ht.klinsurance.project.mapper.ProjectMapper;
import com.ht.klinsurance.project.model.Project;
import com.ht.klinsurance.project.model.ProjectSyncLog;
import com.ht.klinsurance.project.service.IProjectSyncLogService;
import com.ht.klinsurance.report.mapper.ReportBriefingMapper;
import com.ht.klinsurance.report.mapper.ReportMapper;
import com.ht.klinsurance.report.model.Report;
import com.ht.klinsurance.report.model.ReportBriefing;
import com.ht.klinsurance.text.mapper.TextTemplateMapper;
import com.ht.klinsurance.text.mapper.TextTemplateTagMapper;
import com.ht.klinsurance.text.model.TextTemplate;
import com.ht.klinsurance.text.model.TextTemplateTag;
import com.ht.klinsurance.user.mapper.UserMapper;
import com.ht.klinsurance.user.model.User;
import com.ht.klinsurance.word.mapper.WordTemplateMapper;
import com.ht.klinsurance.word.model.WordTemplate;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 项目同步记录信息
 *
 * @author liuqi
 * @date 2016/7/22
 */
@Service
@Transactional
public class ProjectSyncLogServiceImpl implements IProjectSyncLogService {

    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private TextTemplateMapper textTemplateMapper;
    @Resource
    private TextTemplateTagMapper textTemplateTagMapper;
    @Resource
    private WordTemplateMapper wordTemplateMapper;
    @Resource
    private LossItemDictMapper lossItemDictMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private BriefingMapper briefingMapper;
    @Resource
    private BriefingLossMapper briefingLossMapper;
    @Resource
    private BriefingLossImageMapper briefingLossImageMapper;
    @Resource
    private BriefingLossItemMapper briefingLossItemMapper;
    @Resource
    private LossMapper lossMapper;
    @Resource
    private LossItemMapper lossItemMapper;
    @Resource
    private ReportMapper reportMapper;
    @Resource
    private ReportBriefingMapper reportBriefingMapper;

    /**
     * 获取可以同步的数据信息
     * @param userId
     * @param updateTime
     * @param briefingListPh
     * @param briefingLossListPh
     * @param briefingLossImageListPh
     * @param briefingLossItemListPh
     * @param customerListPh
     * @param lossListPh
     * @param lossItemListPh
     * @param reportListPh
     * @param reportBriefingListPh
     * @param textTemplateListPh
     * @return
     */
    @Override
    public HtMap getCanSyncMessage(String userId, Date updateTime, List<Briefing> briefingListPh,
                                   List<BriefingLoss> briefingLossListPh ,
                                   List<BriefingLossImage> briefingLossImageListPh  ,
                                   List<BriefingLossItem> briefingLossItemListPh  ,
                                   List<Customer> customerListPh ,
                                   List<Loss> lossListPh ,
                                   List<LossItem> lossItemListPh ,
                                   List<Report> reportListPh ,
                                   List<ReportBriefing> reportBriefingListPh ,
                                   List<TextTemplate> textTemplateListPh ) {
        HtMap htMap = new HtMap();
        if (StringUtils.isNotBlank(userId)) {
            htMap.put("userId", userId);
        }
        if (updateTime != null) {
            htMap.put("createTime", updateTime);
        }
        //获取项目信息
        List<Project> projectList = projectMapper.findProjectByUserId(htMap);
        //获取客户信息
        List<Customer> customerList = customerMapper.findCustomerList(htMap);
        //获取模板信息（文字模板）
        List<TextTemplate> textTemplateList = textTemplateMapper.findTextTemplateList(htMap);
        List<TextTemplateTag> textTemplateTagList = textTemplateTagMapper.findTextTemplateTagList(htMap);
        //获取模板信息（Word）
        List<WordTemplate> wordTemplateList = wordTemplateMapper.findWordTemplateList(htMap);
        //获取损失项信息
        List<LossItemDict> lossItemDictList = lossItemDictMapper.findLossItemDictList(htMap);
        //获取用户信息
        List<User> userList = userMapper.findList(htMap);
        String count = "";
        Boolean succ = false;
        HtMap resultMap = new HtMap();

        if (projectList != null && projectList.size() > 0) {
            count = count + "<br>项目信息：" + projectList.size() + "条";
            resultMap.put("projectList", HtGson.toJson(projectList));
            succ = true;
        } else {
            count = count + "<br>项目信息：0 条";
        }
        if (customerList != null && customerList.size() > 0) {
            count = count + ";<br><br>客户信息：" + customerList.size() + "条";
            resultMap.put("customerList", HtGson.toJson(customerList));
            succ = true;
        } else{
            count=count+";<br><br>客户信息：0 条";
        }
        if (userList != null && userList.size() > 0) {
            count = count + ";<br><br>通讯录信息：" + userList.size() + "条";
            resultMap.put("userList", HtGson.toJson(userList));
            succ = true;
        } else{
            count=count+";<br><br>通讯录信息：0 条";
        }
        if(textTemplateList!=null&&textTemplateList.size()>0)
        {
            count=count+";<br><br>文字模板信息："+textTemplateList.size()+"条";
            resultMap.put("textTemplateList", HtGson.toJson(textTemplateList));
            succ = true;
        }else {
            count=count+";<br><br>文字模板信息：0 条";
        }
        if(textTemplateTagList!=null&&textTemplateTagList.size()>0)
        {
            resultMap.put("textTemplateTagList", HtGson.toJson(textTemplateTagList));
        }
        if(wordTemplateList!=null&&wordTemplateList.size()>0)
        {
            count=count+";<br><br>模板信息："+wordTemplateList.size()+"条";
            resultMap.put("wordTemplateList", HtGson.toJson(wordTemplateList));
            succ = true;
        }else
        {
            count=count+";<br><br>模板信息：0 条";
        }
        if(lossItemDictList!=null&&lossItemDictList.size()>0)
        {
            count=count+";<br><br>损失项信息："+lossItemDictList.size()+"条";
            resultMap.put("lossItemDictList", HtGson.toJson(lossItemDictList));
            succ = true;
        }else
        {
            count=count+";<br><br>损失项信息：0 条<br><br>";
        }
        if(count.equals(""))
        {
            count="暂无新数据需要同步";
        }
        ProjectSyncLog projectSyncLog = new ProjectSyncLog();
        projectSyncLog.setProjectId(userId);
        projectSyncLog.setContent(count);
        projectSyncLog.setCreateTime(new Date());
        projectSyncLog.setIsSuccess(succ);
        projectSyncLog.setProjectName("数据同步");
        projectSyncLog.setProjectSyncLogId(UUIDGenerate.generate());
        resultMap.put("projectSyncLog", HtGson.toJson(projectSyncLog));
        //将手机端的数据保存到数据库
        if(briefingListPh!=null)
        {
            for(int i = 0;i <briefingListPh.size();i++)
            {
                briefingMapper.deleteByPrimaryKey(briefingListPh.get(i).getBriefingId());
                briefingMapper.addBriefing(briefingListPh.get(i));
            }
        }
        if(briefingLossListPh!=null)
        {
            for(int i = 0;i <briefingLossListPh.size();i++)
            {
                briefingLossMapper.deleteByPrimaryKey(briefingLossListPh.get(i).getBriefingLossId());
                briefingLossMapper.addBriefingLoss(briefingLossListPh.get(i));
            }
        }
        if(briefingLossImageListPh!=null)
        {
            for(int i = 0;i <briefingLossImageListPh.size();i++)
            {
                briefingLossImageMapper.deleteByPrimaryKey(briefingLossImageListPh.get(i).getBriefingLossImageId());
                briefingLossImageMapper.addBriefingLossImage(briefingLossImageListPh.get(i));
            }
        }
        if(briefingLossItemListPh!=null)
        {
            for(int i = 0;i <briefingLossItemListPh.size();i++)
            {
                briefingLossItemMapper.deleteByPrimaryKey(briefingLossItemListPh.get(i).getBriefingLossItemId());
                briefingLossItemMapper.adddBriefingLossItem(briefingLossItemListPh.get(i));
            }
        }
        if(customerListPh!=null)
        {
            for(int i = 0;i <customerListPh.size();i++)
            {
                customerMapper.deleteByPrimaryKey(customerListPh.get(i).getCustomerId());
                customerMapper.addCustomer(customerListPh.get(i));
            }
        }
        if(lossListPh!=null)
        {
            for(int i = 0;i <lossListPh.size();i++)
            {
                lossMapper.deleteByPrimaryKey(lossListPh.get(i).getLossId());
                lossMapper.addLoss(lossListPh.get(i));
            }
        }
        if(lossItemListPh!=null)
        {
            for(int i = 0;i <lossItemListPh.size();i++)
            {
                lossItemMapper.deleteByPrimaryKey(lossItemListPh.get(i).getLossItemId());
                lossItemMapper.addLossItem(lossItemListPh.get(i));
            }
        }
        if(reportListPh!=null)
        {
            for(int i = 0;i <reportListPh.size();i++)
            {
                reportMapper.deleteById(reportListPh.get(i).getReportId());
                reportMapper.addReport(reportListPh.get(i));
            }
        }
        if(reportBriefingListPh!=null)
        {
            for(int i = 0;i <reportBriefingListPh.size();i++)
            {
                reportBriefingMapper.deleteByPrimaryKey(reportBriefingListPh.get(i).getReportBriefingId());
                reportBriefingMapper.addReportBriefing(reportBriefingListPh.get(i));
            }
        }
        if(textTemplateListPh!=null)
        {
            for(int i = 0;i <textTemplateListPh.size();i++)
            {
                textTemplateMapper.deleteByPrimaryKey(textTemplateListPh.get(i).getTextTemplateId());
                textTemplateMapper.addTextTemplate(textTemplateListPh.get(i));
            }
        }
        return resultMap;
    }

    /**
     * 将手机端数据同步到后台
     *
     * @param briefingListPh
     * @param briefingLossListPh
     * @param briefingLossImageListPh
     * @param briefingLossItemListPh
     * @param customerListPh
     * @param lossListPh
     * @param lossItemListPh
     * @param reportListPh
     * @param reportBriefingListPh
     * @param textTemplateListPh
     * @return
     */
    @Override
    public int putPhoneSyncMessage(List<Briefing> briefingListPh, List<BriefingLoss> briefingLossListPh, List<BriefingLossImage> briefingLossImageListPh,
                                     List<BriefingLossItem> briefingLossItemListPh, List<Customer> customerListPh, List<Loss> lossListPh,
                                     List<LossItem> lossItemListPh, List<Report> reportListPh, List<ReportBriefing> reportBriefingListPh,
                                     List<TextTemplate> textTemplateListPh)
    {
        int result  = 1;

        //将手机端的数据保存到数据库
        if(briefingListPh!=null)
        {
            for(int i = 0;i <briefingListPh.size();i++)
            {
                briefingMapper.deleteByPrimaryKey(briefingListPh.get(i).getBriefingId());
                result *= briefingMapper.addBriefing(briefingListPh.get(i));
            }
        }
        if(briefingLossListPh!=null)
        {
            for(int i = 0;i <briefingLossListPh.size();i++)
            {
                briefingLossMapper.deleteByPrimaryKey(briefingLossListPh.get(i).getBriefingLossId());
                result *=  briefingLossMapper.addBriefingLoss(briefingLossListPh.get(i));
            }
        }
        if(briefingLossImageListPh!=null)
        {
            for(int i = 0;i <briefingLossImageListPh.size();i++)
            {
                briefingLossImageMapper.deleteByPrimaryKey(briefingLossImageListPh.get(i).getBriefingLossImageId());
                result *=  briefingLossImageMapper.addBriefingLossImage(briefingLossImageListPh.get(i));
            }
        }
        if(briefingLossItemListPh!=null)
        {
            for(int i = 0;i <briefingLossItemListPh.size();i++)
            {
                briefingLossItemMapper.deleteByPrimaryKey(briefingLossItemListPh.get(i).getBriefingLossItemId());
                result *=  briefingLossItemMapper.adddBriefingLossItem(briefingLossItemListPh.get(i));
            }
        }
        if(customerListPh!=null)
        {
            for(int i = 0;i <customerListPh.size();i++)
            {
                customerMapper.deleteByPrimaryKey(customerListPh.get(i).getCustomerId());
                result *=  customerMapper.addCustomer(customerListPh.get(i));
            }
        }
        if(lossListPh!=null)
        {
            for(int i = 0;i <lossListPh.size();i++)
            {
                lossMapper.deleteByPrimaryKey(lossListPh.get(i).getLossId());
                result *=  lossMapper.addLoss(lossListPh.get(i));
            }
        }
        if(lossItemListPh!=null)
        {
            for(int i = 0;i <lossItemListPh.size();i++)
            {
                lossItemMapper.deleteByPrimaryKey(lossItemListPh.get(i).getLossItemId());
                result *=  lossItemMapper.addLossItem(lossItemListPh.get(i));
            }
        }
        if(reportListPh!=null)
        {
            for(int i = 0;i <reportListPh.size();i++)
            {
                reportMapper.deleteById(reportListPh.get(i).getReportId());
                result *=   reportMapper.addReport(reportListPh.get(i));
            }
        }
        if(reportBriefingListPh!=null)
        {
            for(int i = 0;i <reportBriefingListPh.size();i++)
            {
                reportBriefingMapper.deleteByPrimaryKey(reportBriefingListPh.get(i).getReportBriefingId());
                result *=   reportBriefingMapper.addReportBriefing(reportBriefingListPh.get(i));
            }
        }
        if(textTemplateListPh!=null)
        {
            for(int i = 0;i <textTemplateListPh.size();i++)
            {
                textTemplateMapper.deleteByPrimaryKey(textTemplateListPh.get(i).getTextTemplateId());
                result *= textTemplateMapper.addTextTemplate(textTemplateListPh.get(i));
            }
        }
        return result;
    }
}
