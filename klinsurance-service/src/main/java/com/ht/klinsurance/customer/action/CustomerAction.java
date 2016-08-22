package com.ht.klinsurance.customer.action;

import com.ht.common.gson.HtGson;
import com.ht.common.http.HtResponse;
import com.ht.common.utils.UUIDGenerate;
import com.ht.klinsurance.common.BaseAction;
import com.ht.klinsurance.customer.model.Customer;
import com.ht.klinsurance.customer.service.ICustomerService;
import com.ht.klinsurance.loss.model.LossItemDict;
import com.ht.klinsurance.synce.ICRMSynceDataService;
import com.ht.klinsurance.synce.ISynceDataService;
import com.ht.klinsurance.synce.bean.CRM.CRMInteractiveNoteBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 客户管理
 * @author liuqi
 * @date 2016/8/9
 */
@Controller
@RequestMapping("customerAction")
public class CustomerAction extends BaseAction {
    @Resource
    private ICustomerService customerService;
    @Resource
    private ISynceDataService synceDataService;
    @Resource
    private ICRMSynceDataService crmSynceDataService;
    /**
     * 测试用
     * @param customerJson
     * @param response
     */
    @RequestMapping("addCustomer")
    public void addCustomer(String customerJson, HttpServletResponse response)
    {
        try {
            //Customer customer =  HtGson.fromJson(customerJson, new TypeToken<Customer>() {
            //});
            //customerService.addCustmer(customer);
            //HtResponse.outJson(response, true, null);
            //LossItemDict lossItemDict = new LossItemDict();
            //lossItemDict.setPriceUnit("元");
            //lossItemDict.setName("手机端测试9999");
            //lossItemDict.setNumeraire("6");
            //lossItemDict.setNumeraireMsg("吨");
            //lossItemDict.setRemark("描述");
            //lossItemDict.setLossItemDictPid("1");
            //synceDataService.addLossItemDict(lossItemDict);
            if(customerJson.equals("1"))
            {
                synceDataService.synceUser();
            }else if(customerJson.equals("2")){
                synceDataService.synceCustomer();
            }else if(customerJson.equals("3")){
                synceDataService.synceProjectByUserId("1128263");
            }else if(customerJson.equals("4")){
                synceDataService.synceLossItem();
            }else if(customerJson.equals("5")){
                synceDataService.synceHistoryPriceInfo();
            }else if(customerJson.equals("6")){
                LossItemDict lossItemDict = new LossItemDict();
                lossItemDict.setPriceUnit("元");
                lossItemDict.setName("手机端测试123");
                lossItemDict.setNumeraire("6");
                lossItemDict.setNumeraireMsg("吨");
                lossItemDict.setRemark("描述");
                lossItemDict.setLossItemDictPid("1");
                synceDataService.addLossItemDict(lossItemDict);
            }else if(customerJson.equals("7"))
            {
                crmSynceDataService.synceInteractiveNote("1223");
            }else if(customerJson.equals("8"))
            {
                crmSynceDataService.synceProjcet("1210115");
            }else if(customerJson.equals("9"))
            {
                crmSynceDataService.synceScheduleBean("988562");
            }else if(customerJson.equals("10"))
            {
                CRMInteractiveNoteBean crmInteractiveNoteBean = new CRMInteractiveNoteBean();
                crmInteractiveNoteBean.setID(UUIDGenerate.generate());
                crmInteractiveNoteBean.setCON_TYPE("1");
                crmInteractiveNoteBean.setCUST_ID("1000000010");
                crmInteractiveNoteBean.setCUST_NAME("重庆大足永晟实业发展有限公司");
                crmInteractiveNoteBean.setCONTACT_ID("1132081");
                crmInteractiveNoteBean.setCONTACT_NAME("罗成刚");
                crmInteractiveNoteBean.setCUST_DEPT("信息科技部");
                crmInteractiveNoteBean.setADDRESS("北京市金融大街");
                crmInteractiveNoteBean.setCONTACT_IN("刘琪");
                crmInteractiveNoteBean.setCOMPANY_IN("魏新新");
                crmInteractiveNoteBean.setNEXT_CON_DATE("2106-08-22 14:43:23");
                crmInteractiveNoteBean.setMEMO("主要内容");
                crmSynceDataService.addInteractiveNote(crmInteractiveNoteBean);
            }
        }catch (Exception e)
        {
            log.error("客户", e);
        }
    }

    /**
     *测试用
     * @param response
     */
    @RequestMapping("getCustomer")
    public void getCustomer( HttpServletResponse response)
    {
        List<Customer> customerList = customerService.findCustomer(null);

        HtResponse.outJson(response,HtGson.getGson().toJson(customerList));
    }
}
