package com.ht.klinsurance.synce.impl;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.ht.HtMap;
import com.ht.common.http.HtRequest;
import com.ht.common.utils.UUIDGenerate;
import com.ht.klinsurance.common.KlConsts;
import com.ht.klinsurance.customer.mapper.CustomerMapper;
import com.ht.klinsurance.customer.model.Customer;
import com.ht.klinsurance.loss.mapper.LossItemDictMapper;
import com.ht.klinsurance.loss.mapper.LossItemHistoryPriceMapper;
import com.ht.klinsurance.loss.model.LossItemDict;
import com.ht.klinsurance.loss.model.LossItemHistoryPrice;
import com.ht.klinsurance.project.mapper.ProjectMapper;
import com.ht.klinsurance.project.mapper.ProjectSyncLogMapper;
import com.ht.klinsurance.project.mapper.ProjectUserMapper;
import com.ht.klinsurance.project.model.Project;
import com.ht.klinsurance.project.model.ProjectSyncLog;
import com.ht.klinsurance.synce.ISynceDataService;
import com.ht.klinsurance.synce.bean.*;
import com.ht.klinsurance.synce.util.PingYinUtil;
import com.ht.klinsurance.user.mapper.UserMapper;
import com.ht.klinsurance.user.model.User;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@Transactional
public class SynceDataServiceImpl implements ISynceDataService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private ProjectSyncLogMapper projectSyncLogMapper;
    @Resource
    private CustomerMapper customerMapper;
    @Resource
    private ProjectMapper projectMapper;
    @Resource
    private LossItemDictMapper lossItemDictMapper;
    @Resource
    private ProjectUserMapper projectUserMapper;
    @Resource
    private LossItemHistoryPriceMapper lossItemHistoryPriceMapper;


    /**
     * t同步用户信息
     *
     * @return
     */
    @Override
    public int synceUser()
    {
        int result = 1;


        String resultStr =  HtRequest.post(KlConsts.KLIN_BASE_URL+"/access/getAllAccess", null);
        List<UserBean> userList =  HtGson.fromJson(resultStr, new TypeToken<List<UserBean>>() {
        });
        if(userList!=null&&userList.size()>0)
        {
            List<User> users = new ArrayList<User>();
            for(int i =0 ;i<userList.size();i++)
            {
                User user = new User();
                user.setUserId(userList.get(i).getUSER_ID());
                user.setLoginName(userList.get(i).getUSERNAME());
                user.setName(userList.get(i).getCHINESENAME());
                user.setCompany(userList.get(i).getUNIT());
                user.setDept(userList.get(i).getDEPARTMENT());
                user.setTel(userList.get(i).getPERSONNEL_PHONE());
                user.setMobile(userList.get(i).getPERSONNEL_MOBILE());
                user.setEmail(userList.get(i).getPERSONNEL_EMAIL());
                user.setCreateTime(new Date());
                if(StringUtils.isNotBlank(user.getName())){
                    String name = user.getName();
                    Pattern pattern = Pattern.compile("[0-9]*");
                    Matcher isNum = pattern.matcher(name);
                    if( !isNum.matches() ){
                        user.setNamePinyin(PingYinUtil.getFirstPinYin(name));
                    }else{
                        user.setNamePinyin("*");
                    }
                }
                users.add(user);
            }

            userMapper.deleteAll();
            result*=userMapper.addUserList(users);
        }
        //记录同步信息
        if(result>0)
        {
            projectSyncLogMapper.deleteByPrimaryKey("1");
            ProjectSyncLog projectSyncLog = new ProjectSyncLog();
            projectSyncLog.setProjectSyncLogId("1");
            projectSyncLog.setContent("用户信息保存成功");
            projectSyncLog.setIsSuccess(true);
            projectSyncLog.setCreateTime(new Date());
            projectSyncLogMapper.addProjectSyncLog(projectSyncLog);
        }
        return result;
    }

    /**
     * 同步客户信息
     * @return
     */
    @Override
    public int synceCustomer() {
        int result = 1;

        String resultStr =  HtRequest.post(KlConsts.KLIN_BASE_URL+"/customer/getAllCustomer", null);
        List<CustomerBean> customerBeanList =  HtGson.fromJson(resultStr, new TypeToken<List<CustomerBean>>() {
        });
        if(customerBeanList!=null&&customerBeanList.size()>0) {
            List<Customer> customerList = new ArrayList<Customer>();
            for (int i = 0; i < customerBeanList.size(); i++) {
                Customer customer = new Customer();
                customer.setCreateTime(new Date());
                customer.setCustomerId(customerBeanList.get(i).getCUSTOMER_ID());
                customer.setName(customerBeanList.get(i).getNAME());
                customer.setSuperiorId(customerBeanList.get(i).getSUPERIOR_ID());
                customer.setSuperior(customerBeanList.get(i).getSUPERIOR());
                if(customerBeanList.get(i).getCONTACTS_NAME()!=null)
                {

                    customer.setLinkMan(customerBeanList.get(i).getCONTACTS_NAME());
                }
                if(customerBeanList.get(i).getNAME()!=null){
                    String name = customerBeanList.get(i).getNAME();
                    Pattern pattern = Pattern.compile("[0-9]*");
                    Matcher isNum = pattern.matcher(name);
                    if( !isNum.matches() ){
                        customer.setLinkManPinyin(PingYinUtil.getFirstPinYin(name));
                    }else{
                        customer.setLinkManPinyin("*");
                    }
                }
                if(customerBeanList.get(i).getPHONE()!=null){
                    customer.setLinkPhone(customerBeanList.get(i).getPHONE());
                }
                customer.setProvince(customerBeanList.get(i).getPROVINCE_NAME());
                customer.setCity(customerBeanList.get(i).getCITY_NAME());
                if(customerBeanList.get(i).getDISTRICT_NAME()!=null)
                {
                    customer.setCounty(customerBeanList.get(i).getDISTRICT_NAME());
                }
                customer.setAddress(customerBeanList.get(i).getADDRESS());
                customer.setClassification(customerBeanList.get(i).getCLASSIFICATION());
                customerList.add(customer);
            }
            customerMapper.deleteAll();
            result*=customerMapper.addCustomerList(customerList);
            //记录同步信息
            if(result>0)
            {
                projectSyncLogMapper.deleteByPrimaryKey("2");
                ProjectSyncLog projectSyncLog = new ProjectSyncLog();
                projectSyncLog.setProjectSyncLogId("2");
                projectSyncLog.setContent("客户信息保存成功");
                projectSyncLog.setIsSuccess(true);
                projectSyncLog.setCreateTime(new Date());
                projectSyncLogMapper.addProjectSyncLog(projectSyncLog);
            }
        }
        return result;
    }

    /**
     * 同步项目信息!!!!!!!!---------------注意该方法弃用------------------------
     *
     * @return
     */
    @Override
    public int synceProject()
    {
        int result = 1;
        //HtMap htMap = new HtMap();
        //String resultStr =  HtRequest.post(KlConsts.KLIN_BASE_URL+"/project/getAllProject", htMap);
        //List<ProjectBean> projectBeanList =  HtGson.fromJson(resultStr, new TypeToken<List<ProjectBean>>() {
        //});
        //if(projectBeanList!=null&&projectBeanList.size()>0) {
        //    List<Project> projectList = new ArrayList<Project>();
        //    for (int i = 0; i < projectBeanList.size(); i++) {
        //        Project project = new Project();
        //        project.setProjectId(projectBeanList.get(i).getID());
        //        project.setProjectNo(projectBeanList.get(i).getPROJECT_NUM());
        //        project.setProjectSponsor(projectBeanList.get(i).getOPERATOR_NAME());
        //        project.setProjectName(projectBeanList.get(i).getNAME());
        //        project.setInsurerId(projectBeanList.get(i).getINSURED());
        //        project.setInsurerName(projectBeanList.get(i).getINSURED_NAME());
        //        project.setProjectTime(projectBeanList.get(i).getSTART_DT());
        //        project.setInsureNo(projectBeanList.get(i).getINSURANCE_TYPE());
        //        project.setInsureName(projectBeanList.get(i).getINSURANCE_TYPE_NAME());
        //        project.setAccidentTime(projectBeanList.get(i).getACCIDENT_TIME());
        //        project.setAccidentSite(projectBeanList.get(i).getACCIDENTPLACE());
        //        project.setAccidentCause(projectBeanList.get(i).getCASE_REASON_VALUE());
        //        project.setCreateTime(new Date());
        //        projectList.add(project);
        //
        //    }
        //    projectMapper.deleteAll();
        //    result*=projectMapper.addProjectList(projectList);
        //    //记录同步信息
        //    if(result>0)
        //    {
        //        projectSyncLogMapper.deleteByPrimaryKey("3");
        //        ProjectSyncLog projectSyncLog = new ProjectSyncLog();
        //        projectSyncLog.setProjectSyncLogId("3");
        //        projectSyncLog.setContent("项目信息保存成功");
        //        projectSyncLog.setIsSuccess(true);
        //        projectSyncLog.setCreateTime(new Date());
        //        projectSyncLogMapper.addProjectSyncLog(projectSyncLog);
        //    }
        //}
        return result;
    }

    /**
     * 同步项目信息
     *
     * @param userId
     * @return
     */
    @Override
    public int synceProjectByUserId(String userId) {
        int result = 1;
        String resultStr =  HtRequest.post(KlConsts.KLIN_BASE_URL+"/project/getProject/"+userId, null);
        List<ProjectBean> projectBeanList =  HtGson.fromJson(resultStr, new TypeToken<List<ProjectBean>>() {
        });
        if(projectBeanList!=null&&projectBeanList.size()>0) {
            List<Project> projectList = new ArrayList<Project>();
            for (int i = 0; i < projectBeanList.size(); i++) {
                Project project = new Project();
                project.setProId(UUIDGenerate.generate());
                project.setProjectId(projectBeanList.get(i).getID());
                project.setProjectNo(projectBeanList.get(i).getPROJECT_NUM());
                project.setProjectSponsor(projectBeanList.get(i).getOPERATOR_NAME());
                project.setProjectName(projectBeanList.get(i).getNAME());
                project.setInsurerId(projectBeanList.get(i).getINSURED());
                project.setInsurerName(projectBeanList.get(i).getINSURED_NAME());
                project.setProjectTime(projectBeanList.get(i).getSTART_DT());
                project.setInsureNo(projectBeanList.get(i).getINSURANCE_TYPE());
                project.setInsureName(projectBeanList.get(i).getINSURANCE_TYPE_NAME());
                project.setAccidentTime(projectBeanList.get(i).getACCIDENT_TIME());
                project.setAccidentSite(projectBeanList.get(i).getACCIDENTPLACE());
                project.setAccidentCause(projectBeanList.get(i).getCASE_REASON_VALUE());
                project.setCreateTime(new Date());
                project.setUserId(userId);
                project.setResponsibilityName(projectBeanList.get(i).getDUTY_CERTIFY_NAME());
                project.setResponsibilityNo(projectBeanList.get(i).getDUTY_CERTIFY_CODE());
                project.setCertificationCode(projectBeanList.get(i).getQUALIFICATION_CODE());
                project.setInsureDeadline(projectBeanList.get(i).getINSURANCE_TERM());
                projectList.add(project);
            }
            projectMapper.deleteByUserId(userId);
            result*=projectMapper.addProjectList(projectList);
            //记录同步信息
            if(result>0)
            {
                projectSyncLogMapper.deleteByPrimaryKey("4");
                ProjectSyncLog projectSyncLog = new ProjectSyncLog();
                projectSyncLog.setProjectSyncLogId("4");
                projectSyncLog.setContent("根据用户同步项目信息保存成功");
                projectSyncLog.setIsSuccess(true);
                projectSyncLog.setCreateTime(new Date());
                projectSyncLogMapper.addProjectSyncLog(projectSyncLog);
            }
        }
        return result;
    }

    /**
     * 同步损失项信息
     * @return
     */
    @Override
    public int synceLossItem() {
        int result = 1;

        String resultStr =  HtRequest.post(KlConsts.KLIN_BASE_URL+"/loseProject/getAllLoseProject", null);
        List<LossItemDictBean> lossItemDictBeanList =  HtGson.fromJson(resultStr, new TypeToken<List<LossItemDictBean>>() {
        });
        if(lossItemDictBeanList!=null&&lossItemDictBeanList.size()>0) {
            List<LossItemDict> lossItemDictList = new ArrayList<LossItemDict>();
            for (int i = 0; i < lossItemDictBeanList.size(); i++) {
                LossItemDict lossItemDict = new LossItemDict();
                lossItemDict.setLossItemDictId(lossItemDictBeanList.get(i).getID());
                lossItemDict.setCreateTime(new Date());
                lossItemDict.setNumeraire(lossItemDictBeanList.get(i).getNUMERAIRE());
                lossItemDict.setNumeraireMsg(lossItemDictBeanList.get(i).getNUMERAIREMSG());
                lossItemDict.setName(lossItemDictBeanList.get(i).getNAME());
                lossItemDict.setLossItemDictNo(lossItemDictBeanList.get(i).getNO());
                if(lossItemDictBeanList.get(i).getPARENT()==null)
                {
                    lossItemDict.setLossItemDictPid("0");
                }else {
                    lossItemDict.setLossItemDictPid(lossItemDictBeanList.get(i).getPARENT());
                }
                lossItemDict.setRemark(lossItemDictBeanList.get(i).getDESCRIPTION());
                lossItemDict.setPriceUnit(lossItemDictBeanList.get(i).getMONEY_TYPE());
                lossItemDictList.add(lossItemDict);
            }
            lossItemDictMapper.deleteAll();
            result*=lossItemDictMapper.addLossItemDictList(lossItemDictList);
            //记录同步信息
            if(result>0)
            {
                projectSyncLogMapper.deleteByPrimaryKey("5");
                ProjectSyncLog projectSyncLog = new ProjectSyncLog();
                projectSyncLog.setProjectSyncLogId("5");
                projectSyncLog.setContent("损失项列表信息保存成功");
                projectSyncLog.setIsSuccess(true);
                projectSyncLog.setCreateTime(new Date());
                projectSyncLogMapper.addProjectSyncLog(projectSyncLog);
            }
        }
        return result;
    }

    /**
     * 同步项目与用户关系（暂时弃用）
     *
     * @return
     */
    @Override
    public int synceProjectUser() {
        int result = 1;

        //String resultStr =  HtRequest.post(KlConsts.KLIN_BASE_URL+"/proMember/getAllProMember", null);
        //List<ProjectUserBean> projectUserBeanList =  HtGson.fromJson(resultStr, new TypeToken<List<ProjectUserBean>>() {
        //});
        //if(projectUserBeanList!=null&&projectUserBeanList.size()>0) {
        //    List<ProjectUser>  projectUserList = new ArrayList<ProjectUser>();
        //    for (int i = 0; i < projectUserBeanList.size(); i++) {
        //        ProjectUser projectUser = new ProjectUser();
        //        projectUser.setProjectUserId(projectUserBeanList.get(i).getID());
        //        projectUser.setUserId(projectUserBeanList.get(i).getUSER_ID());
        //        projectUser.setProjectId(projectUserBeanList.get(i).getPROJECT_ID());
        //        projectUser.setUserName(projectUserBeanList.get(i).getUSERNAME());
        //        projectUser.setChineseName(projectUserBeanList.get(i).getCHINESENAME());
        //        projectUser.setDuty(projectUserBeanList.get(i).getDUTY());
        //        projectUser.setCertificateNo(projectUserBeanList.get(i).getCERTIFICATE_NO());
        //        projectUser.setCreateTime(new Date());
        //        projectUserList.add(projectUser);
        //    }
        //    projectUserMapper.deleteAll();
        //    result*=projectUserMapper.addProjectUser(projectUserList);
        //    //记录同步信息
        //    if(result>0)
        //    {
        //        projectSyncLogMapper.deleteByPrimaryKey("6");
        //        ProjectSyncLog projectSyncLog = new ProjectSyncLog();
        //        projectSyncLog.setProjectSyncLogId("6");
        //        projectSyncLog.setContent("用户与项目关系保存成功");
        //        projectSyncLog.setIsSuccess(true);
        //        projectSyncLog.setCreateTime(new Date());
        //        projectSyncLogMapper.addProjectSyncLog(projectSyncLog);
        //    }
        //}
        return result;
    }

    /**
     * 根据用户id查询项目与用户关系(暂时弃用)
     *
     * @param userId
     * @return
     */
    @Override
    public int synceProjectUserByUserId(String userId) {

        int result = 1;

        //String resultStr =  HtRequest.post(KlConsts.KLIN_BASE_URL+"/proMember/getProMember/"+userId, null);
        //List<ProjectUserBean> projectUserBeanList =  HtGson.fromJson(resultStr, new TypeToken<List<ProjectUserBean>>() {
        //});
        //if(projectUserBeanList!=null&&projectUserBeanList.size()>0) {
        //    List<ProjectUser>  projectUserList = new ArrayList<ProjectUser>();
        //    for (int i = 0; i < projectUserBeanList.size(); i++) {
        //        ProjectUser projectUser = new ProjectUser();
        //        projectUser.setProjectUserId(projectUserBeanList.get(i).getID());
        //        projectUser.setUserId(projectUserBeanList.get(i).getUSER_ID());
        //        projectUser.setProjectId(projectUserBeanList.get(i).getPROJECT_ID());
        //        projectUser.setUserName(projectUserBeanList.get(i).getUSERNAME());
        //        projectUser.setChineseName(projectUserBeanList.get(i).getCHINESENAME());
        //        projectUser.setDuty(projectUserBeanList.get(i).getDUTY());
        //        projectUser.setCertificateNo(projectUserBeanList.get(i).getCERTIFICATE_NO());
        //        projectUser.setCreateTime(new Date());
        //        projectUserList.add(projectUser);
        //    }
        //    projectUserMapper.deleteByUserId(userId);
        //    result*=projectUserMapper.addProjectUser(projectUserList);
        //    //记录同步信息
        //    if(result>0)
        //    {
        //        projectSyncLogMapper.deleteByPrimaryKey("7");
        //        ProjectSyncLog projectSyncLog = new ProjectSyncLog();
        //        projectSyncLog.setProjectSyncLogId("7");
        //        projectSyncLog.setContent("根据用户id查询用户与项目关系保存成功");
        //        projectSyncLog.setIsSuccess(true);
        //        projectSyncLog.setCreateTime(new Date());
        //        projectSyncLogMapper.addProjectSyncLog(projectSyncLog);
        //    }
        //}
        return result;
    }

    /**
     * 同步历史损失项信息
     * @return
     */
    @Override
    public int synceHistoryPriceInfo() {
        int result = 1;
        String resultStr =  HtRequest.post(KlConsts.KLIN_BASE_URL+"/historyPriceInfo/getAllHistoryPriceInfo", null);
        List<HistoryPriceInfoBean> historyPriceInfoBeanList =  HtGson.fromJson(resultStr, new TypeToken<List<HistoryPriceInfoBean>>() {
        });
        if(historyPriceInfoBeanList!=null&&historyPriceInfoBeanList.size()>0) {
            List<LossItemHistoryPrice>  lossItemHistoryPriceList = new ArrayList<LossItemHistoryPrice>();
            for (int i = 0; i < historyPriceInfoBeanList.size(); i++) {
                LossItemHistoryPrice lossItemHistoryPrice = new LossItemHistoryPrice();
                lossItemHistoryPrice.setHistoryPriceId(historyPriceInfoBeanList.get(i).getID());
                lossItemHistoryPrice.setAmount(historyPriceInfoBeanList.get(i).getAMOUNT());
                lossItemHistoryPrice.setHeight(historyPriceInfoBeanList.get(i).getHEIGHT());
                lossItemHistoryPrice.setLength(historyPriceInfoBeanList.get(i).getLENGTH());
                lossItemHistoryPrice.setPlace(historyPriceInfoBeanList.get(i).getPLACE());
                lossItemHistoryPrice.setPrice(historyPriceInfoBeanList.get(i).getPRICE());
                lossItemHistoryPrice.setProjectId(historyPriceInfoBeanList.get(i).getPROJECT_ID());
                lossItemHistoryPrice.setProjectName(historyPriceInfoBeanList.get(i).getPROJECT_NAME());
                lossItemHistoryPrice.setRealPrice(historyPriceInfoBeanList.get(i).getREAL_PRICE());
                lossItemHistoryPrice.setRemark(historyPriceInfoBeanList.get(i).getREMARK());
                lossItemHistoryPrice.setReportedLoss(historyPriceInfoBeanList.get(i).getREPORTED_LOSS());
                lossItemHistoryPrice.setWidth(historyPriceInfoBeanList.get(i).getWIDTH());
                lossItemHistoryPrice.setItemId(historyPriceInfoBeanList.get(i).getITEM_ID());
                lossItemHistoryPrice.setItemName(historyPriceInfoBeanList.get(i).getITEM_NAME());
                lossItemHistoryPrice.setStandardId(historyPriceInfoBeanList.get(i).getSTANDARD_ID());
                lossItemHistoryPrice.setStandardName(historyPriceInfoBeanList.get(i).getSTANDARD_NAME());
                lossItemHistoryPrice.setStandatdItemId(historyPriceInfoBeanList.get(i).getSTANDARD_ITEM_ID());
                lossItemHistoryPriceList.add(lossItemHistoryPrice);
            }
            lossItemHistoryPriceMapper.deleteAll();
            result*=lossItemHistoryPriceMapper.addLossItemHistoryPrice(lossItemHistoryPriceList);
            //记录同步信息
            if(result>0)
            {
                projectSyncLogMapper.deleteByPrimaryKey("8");
                ProjectSyncLog projectSyncLog = new ProjectSyncLog();
                projectSyncLog.setProjectSyncLogId("8");
                projectSyncLog.setContent("历史损失项保存成功");
                projectSyncLog.setIsSuccess(true);
                projectSyncLog.setCreateTime(new Date());
                projectSyncLogMapper.addProjectSyncLog(projectSyncLog);
            }
        }
        return result;
    }

    /**
     * 增加损失项接口
     *
     * @param lossItemDict
     * @return
     */
    @Override
    public LossItemDict addLossItemDict(LossItemDict lossItemDict) {
       try {
           int result = 1;
           LossItemDictBean  lossItemDictBean = new LossItemDictBean();
           lossItemDictBean.setDESCRIPTION(lossItemDict.getRemark());
           lossItemDictBean.setMONEY_TYPE(lossItemDict.getPriceUnit());
           lossItemDictBean.setNAME(lossItemDict.getName());
           lossItemDictBean.setNUMERAIRE(lossItemDict.getNumeraire());
           lossItemDictBean.setNUMERAIREMSG(lossItemDict.getNumeraireMsg());
           lossItemDictBean.setPARENT( lossItemDict.getLossItemDictPid());
           String itemStr = HtGson.toJson(lossItemDictBean, new TypeToken<LossItemDictBean>() {
           });
           HtMap htMap = new HtMap();
           try {
               htMap.put("loseJson", URLEncoder.encode(itemStr, "UTF-8"));
           } catch (UnsupportedEncodingException e) {
               e.printStackTrace();
           }
           String resultStr =  HtRequest.post(KlConsts.KLIN_BASE_URL + "/add/loseProject", htMap);
           JsonObject jsonObject = HtGson.fromJson(resultStr, new TypeToken<JsonObject>() {
           });
           lossItemDict.setLossItemDictId(jsonObject.get("ID").toString());
           lossItemDict.setLossItemDictNo(jsonObject.get("NO").toString());
           lossItemDict.setCreateTime(new Date());
           result = lossItemDictMapper.addLossItemDict(lossItemDict);
       }catch (Exception e)
       {
           return null;
       }
        return lossItemDict;
    }
}
