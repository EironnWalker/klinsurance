package com.ht.klinsurance.synce.impl;

import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.ht.HtMap;
import com.ht.common.http.HtRequest;
import com.ht.klinsurance.common.KlConsts;
import com.ht.klinsurance.crm.mapper.CrmInteractiveNoteMapper;
import com.ht.klinsurance.crm.mapper.CrmProjectMapper;
import com.ht.klinsurance.crm.mapper.CrmScheduleMapper;
import com.ht.klinsurance.crm.model.CrmInteractiveNote;
import com.ht.klinsurance.crm.model.CrmProject;
import com.ht.klinsurance.crm.model.CrmSchedule;
import com.ht.klinsurance.synce.ICRMSynceDataService;
import com.ht.klinsurance.synce.bean.CRM.CRMInteractiveNoteBean;
import com.ht.klinsurance.synce.bean.CRM.CRMProjcetBean;
import com.ht.klinsurance.synce.bean.CRM.CRMScheduleBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class CRMSynceDataServiceImpl implements ICRMSynceDataService {

    @Resource
    private CrmInteractiveNoteMapper crmInteractiveNoteMapper;
    @Resource
    private CrmProjectMapper crmProjectMapper;
    @Resource
    private CrmScheduleMapper crmScheduleMapper;
    /**
     * 交互记录
     *
     * @return
     */
    @Override
    public int synceInteractiveNote(String userId) {
        int result = 1;


        String resultStr =  HtRequest.post(KlConsts.KLIN_BASE_URL + "/interactiveNote/getAllinteractiveNote/"+userId, null);
        List<CRMInteractiveNoteBean> cRMInteractiveNoteBeanList =  HtGson.fromJson(resultStr, new TypeToken<List<CRMInteractiveNoteBean>>() {
        });
        if(cRMInteractiveNoteBeanList!=null&&cRMInteractiveNoteBeanList.size()>0) {
            List<CrmInteractiveNote> crmInteractiveNotes = new ArrayList<CrmInteractiveNote>();
            for (int i = 0; i < cRMInteractiveNoteBeanList.size(); i++)
            {
                CrmInteractiveNote crmInteractiveNote = new CrmInteractiveNote();

                crmInteractiveNote.setInteractiveNoteId(cRMInteractiveNoteBeanList.get(i).getID());
                crmInteractiveNote.setReceiveId(cRMInteractiveNoteBeanList.get(i).getRECEIVE_ID());
                crmInteractiveNote.setTranType(cRMInteractiveNoteBeanList.get(i).getTRAN_TYPE());
                crmInteractiveNote.setCreateDate(cRMInteractiveNoteBeanList.get(i).getCREATE_DATE());
                crmInteractiveNote.setCustModFlag(cRMInteractiveNoteBeanList.get(i).getCUST_MOD_FLAG());
                crmInteractiveNote.setContactModFlag(cRMInteractiveNoteBeanList.get(i).getCONTACT_MOD_FLAG());
                crmInteractiveNote.setMemo(cRMInteractiveNoteBeanList.get(i).getMEMO());
                crmInteractiveNote.setVersion(cRMInteractiveNoteBeanList.get(i).getVERSION());
                crmInteractiveNote.setTranDate(cRMInteractiveNoteBeanList.get(i).getTRAN_DATE());
                crmInteractiveNote.setProjectId(cRMInteractiveNoteBeanList.get(i).getPROJECT_ID());
                crmInteractiveNote.setProjectName(cRMInteractiveNoteBeanList.get(i).getPROJECT_NAME());
                crmInteractiveNote.setCustId(cRMInteractiveNoteBeanList.get(i).getCUST_ID());
                crmInteractiveNote.setCustName(cRMInteractiveNoteBeanList.get(i).getCUST_NAME());
                crmInteractiveNote.setContactId(cRMInteractiveNoteBeanList.get(i).getCONTACT_ID());
                crmInteractiveNote.setContactName(cRMInteractiveNoteBeanList.get(i).getCONTACT_NAME());
                crmInteractiveNote.setCaseId(cRMInteractiveNoteBeanList.get(i).getCASE_ID());
                crmInteractiveNote.setCaseName(cRMInteractiveNoteBeanList.get(i).getCASE_NAME());
                crmInteractiveNote.setCreateName(cRMInteractiveNoteBeanList.get(i).getCREATE_NAME());
                crmInteractiveNote.setCurCustSt(cRMInteractiveNoteBeanList.get(i).getCUR_CUST_ST());
                crmInteractiveNote.setCurProjectSt(cRMInteractiveNoteBeanList.get(i).getCUR_PROJECT_ST());
                crmInteractiveNote.setCurCustSt(cRMInteractiveNoteBeanList.get(i).getCUR_CONTACT_ST());
                crmInteractiveNote.setNextConDate(cRMInteractiveNoteBeanList.get(i).getNEXT_CON_DATE());
                crmInteractiveNote.setCompanyIn(cRMInteractiveNoteBeanList.get(i).getCOMPANY_IN());
                crmInteractiveNote.setContactIn(cRMInteractiveNoteBeanList.get(i).getCONTACT_IN());
                crmInteractiveNote.setConType(cRMInteractiveNoteBeanList.get(i).getCON_TYPE());
                crmInteractiveNote.setPrimsecId(cRMInteractiveNoteBeanList.get(i).getPRIMSEC_ID());
                crmInteractiveNote.setProjProg(cRMInteractiveNoteBeanList.get(i).getPROJ_PROG());
                crmInteractiveNote.setProjTast(cRMInteractiveNoteBeanList.get(i).getPROJ_TAST());
                crmInteractiveNote.setCaseProg(cRMInteractiveNoteBeanList.get(i).getCASE_PROG());
                crmInteractiveNote.setCaseTast(cRMInteractiveNoteBeanList.get(i).getCASE_TAST());
                crmInteractiveNote.setPreorcust(cRMInteractiveNoteBeanList.get(i).getPRE_CUST_TAST());
                crmInteractiveNote.setOtherTast(cRMInteractiveNoteBeanList.get(i).getOTHER_TAST());
                crmInteractiveNote.setPreorproj(cRMInteractiveNoteBeanList.get(i).getPREORPROJ());
                crmInteractiveNote.setPreorcust(cRMInteractiveNoteBeanList.get(i).getPREORCUST());
                crmInteractiveNote.setAddress(cRMInteractiveNoteBeanList.get(i).getADDRESS());
                crmInteractiveNote.setCustDept(cRMInteractiveNoteBeanList.get(i).getCUST_DEPT());
                crmInteractiveNote.setTrainTitle(cRMInteractiveNoteBeanList.get(i).getTRAIN_TITLE());
                crmInteractiveNote.setProblem(cRMInteractiveNoteBeanList.get(i).getPROBLEM());
                crmInteractiveNote.setOfferValid(cRMInteractiveNoteBeanList.get(i).getOFFER_VALID());
                crmInteractiveNote.setCaseTastName(cRMInteractiveNoteBeanList.get(i).getCASE_TAST_NAME());
                crmInteractiveNote.setMailName(cRMInteractiveNoteBeanList.get(i).getMAIL_NAME());
                crmInteractiveNote.setMailId(cRMInteractiveNoteBeanList.get(i).getMAIL_ID());
                crmInteractiveNote.setOperatorCode(cRMInteractiveNoteBeanList.get(i).getOPERATOR_CODE());
                crmInteractiveNote.setOperatorName(cRMInteractiveNoteBeanList.get(i).getOPERATOR_NAME());
                crmInteractiveNote.setOperatorDate(cRMInteractiveNoteBeanList.get(i).getOPERATOR_DATE());
                crmInteractiveNote.setBelongsId(cRMInteractiveNoteBeanList.get(i).getBELONGS_ID());
                crmInteractiveNote.setBelongsDept(cRMInteractiveNoteBeanList.get(i).getBELONGS_DEPT());
                crmInteractiveNote.setBelongsDeptId(cRMInteractiveNoteBeanList.get(i).getBELONGS_DEPT_ID());
                crmInteractiveNote.setBelongs(cRMInteractiveNoteBeanList.get(i).getBELONGS());
                crmInteractiveNote.setProjType(cRMInteractiveNoteBeanList.get(i).getPROJ_TYPE());
                crmInteractiveNote.setCustType(cRMInteractiveNoteBeanList.get(i).getCUST_TYPE());
                crmInteractiveNote.setUserId(userId);
                //crmInteractiveNote.setCompanyIn(cRMInteractiveNoteBeanList.get(i).getCOMPANY_IN_CODE());
                crmInteractiveNotes.add(crmInteractiveNote);
            }
            crmInteractiveNoteMapper.deleteAllByusrId(userId);
            result*=crmInteractiveNoteMapper.insertCrmInteractiveNoteList(crmInteractiveNotes);
        }
        return result;
    }

    /**
     * 增加交互记录
     *
     * @param crmInteractiveNoteBean
     * @return
     */
    @Override
    public int addInteractiveNote(CRMInteractiveNoteBean crmInteractiveNoteBean) {
        try {
            String itemStr = HtGson.toJson(crmInteractiveNoteBean, new TypeToken<CRMInteractiveNoteBean>() {
            });
            HtMap htMap = new HtMap();
            try {
                htMap.put("noteJson", URLEncoder.encode(itemStr, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String resultStr =  HtRequest.post(KlConsts.KLIN_BASE_URL + "/add/interNote\n", htMap);

        }catch (Exception e)
        {
            return 0;
        }
        return 1;
    }

    /**
     * 项目
     *
     * @param userId
     * @return
     */
    @Override
    public int synceProjcet(String userId) {

        int result = 1;
        String resultStr =  HtRequest.post(KlConsts.KLIN_BASE_URL + "/preSale/getPreSaleProject/"+userId, null);
        List<CRMProjcetBean> cRMProjcetBeanList =  HtGson.fromJson(resultStr, new TypeToken<List<CRMProjcetBean>>() {
        });
        if(cRMProjcetBeanList!=null&&cRMProjcetBeanList.size()>0) {
            List<CrmProject> crmProjects = new ArrayList<CrmProject>();
            for (int i = 0; i < cRMProjcetBeanList.size(); i++) {

                CrmProject crmProject = new CrmProject();
                crmProject.setProjectId(cRMProjcetBeanList.get(i).getID());
                crmProject.setProjectNum(cRMProjcetBeanList.get(i).getPROJECT_NUM());
                crmProject.setBussSrc(cRMProjcetBeanList.get(i).getBUSS_SRC());
                crmProject.setBussType(cRMProjcetBeanList.get(i).getBUSS_TYPE());
                crmProject.setBussOrg(cRMProjcetBeanList.get(i).getBUSS_ORG());
                crmProject.setPrincipal(cRMProjcetBeanList.get(i).getPRINCIPAL());
                crmProject.setOperatorId(cRMProjcetBeanList.get(i).getOPERATOR_ID());
                crmProject.setNature(cRMProjcetBeanList.get(i).getNATURE());
                crmProject.setStartDt(cRMProjcetBeanList.get(i).getSTART_DT());
                crmProject.setEndDt(cRMProjcetBeanList.get(i).getEND_DT());
                crmProject.setName(cRMProjcetBeanList.get(i).getNAME());
                crmProject.setPredictionCost(cRMProjcetBeanList.get(i).getPREDICTION_COST());
                crmProject.setPredictionIncome(cRMProjcetBeanList.get(i).getPREDICTION_INCOME());
                crmProject.setContactId(cRMProjcetBeanList.get(i).getCONTACT_ID());
                crmProject.setProjectMember(cRMProjcetBeanList.get(i).getPROJECT_MEMBER());
                crmProject.setDescriptiom(cRMProjcetBeanList.get(i).getDESCRIPTION());
                crmProject.setRemark(cRMProjcetBeanList.get(i).getREMARK());
                crmProject.setStatus(cRMProjcetBeanList.get(i).getSTATUS());
                crmProject.setPredictionPremium(cRMProjcetBeanList.get(i).getPREDICTION_PREMIUM());
                crmProject.setBussOrgName(cRMProjcetBeanList.get(i).getBUSS_ORG_NAME());
                crmProject.setPrincipalName(cRMProjcetBeanList.get(i).getPRINCIPAL_NAME());
                crmProject.setOperatorName(cRMProjcetBeanList.get(i).getOPERATOR_NAME());
                crmProject.setContactName(cRMProjcetBeanList.get(i).getCONTACT_NAME());
                crmProject.setAbroad(cRMProjcetBeanList.get(i).getABROAD());
                crmProject.setCtrlType(cRMProjcetBeanList.get(i).getCTRL_TYPE());
                crmProject.setCurrency(cRMProjcetBeanList.get(i).getCURRENCY());
                crmProject.setCreaterId(cRMProjcetBeanList.get(i).getCREATER_ID());
                //crmProject.setcrea(cRMProjcetBeanList.get(i).getCREATE_DATE());
                //crmProject.setCreaterId(cRMProjcetBeanList.get(i).getCREATER_NAME());
                crmProject.setDocking(cRMProjcetBeanList.get(i).getDOCKING());
                crmProject.setProjSector(cRMProjcetBeanList.get(i).getPROJ_SECTOR());
                crmProject.setProjChannel(cRMProjcetBeanList.get(i).getPROJ_CHANNEL());
                crmProject.setCurrentNode(cRMProjcetBeanList.get(i).getCURRENT_NODE());
                crmProject.setCurrentStatus(cRMProjcetBeanList.get(i).getCURRENT_STATUS());
                crmProject.setProjType(cRMProjcetBeanList.get(i).getPROJ_TYPE());
                crmProject.setRenewalId(cRMProjcetBeanList.get(i).getRENEWAL_ID());

                crmProject.setRenewalTimes(cRMProjcetBeanList.get(i).getRENEWAL_TIMES());
                crmProject.setRenewalName(cRMProjcetBeanList.get(i).getRENEWAL_NAME());
                crmProject.setFlowType(cRMProjcetBeanList.get(i).getFLOW_TYPE());
                crmProject.setBidEndDt(cRMProjcetBeanList.get(i).getBID_END_DT());
                crmProject.setBillEndDt(cRMProjcetBeanList.get(i).getBILL_END_DT());
                crmProject.setLocations(cRMProjcetBeanList.get(i).getLOCATIONS());
                crmProject.setIsFinish(cRMProjcetBeanList.get(i).getIS_FINISH());
                crmProject.setCancelResult(cRMProjcetBeanList.get(i).getCANCEL_RESULT());
                crmProject.setFinishDate(cRMProjcetBeanList.get(i).getFINISH_DATE());
                crmProject.setProcessDate(cRMProjcetBeanList.get(i).getPROCESS_DATE());
                crmProject.setInsuranceType(cRMProjcetBeanList.get(i).getINSURANCE_TYPE());
                crmProject.setInsuranceType1(cRMProjcetBeanList.get(i).getINSURANCE_TYPE1());
                crmProject.setTbFlag(cRMProjcetBeanList.get(i).getTB_FLAG());
                crmProject.setCreaterUnitid(cRMProjcetBeanList.get(i).getCREATER_UNITID());

                crmProject.setCreaterDeptid(cRMProjcetBeanList.get(i).getCREATER_DEPTID());
                crmProject.setAffiliationId(cRMProjcetBeanList.get(i).getAFFILIATION_ID());
                crmProject.setSpacecp(cRMProjcetBeanList.get(i).getSPACECP());
                crmProject.setCommissiondate(cRMProjcetBeanList.get(i).getCOMMISSIONDATE());
                crmProject.setCrmProjectId(cRMProjcetBeanList.get(i).getCRM_PROJECT_ID());
                crmProject.setIsDelegation(cRMProjcetBeanList.get(i).getIS_DELEGATION());
                crmProject.setBussImportant1(cRMProjcetBeanList.get(i).getBUSS_IMPORTANT1());
                crmProject.setBussImportant2(cRMProjcetBeanList.get(i).getBUSS_IMPORTANT2());
                crmProject.setUserId(userId);
                crmProjects.add(crmProject);
            }
            crmProjectMapper.deleteByUserId(userId);
            result*= crmProjectMapper.addCrmProjectList(crmProjects);
        }
        return result;
    }

    /**
     * 日程
     *
     * @return
     */
    @Override
    public int synceScheduleBean(String userId) {

        int result = 1;
        String resultStr =  HtRequest.post(KlConsts.KLIN_BASE_URL + "/schedule/getAllSchedule/"+userId, null);
        List<CRMScheduleBean> cRMScheduleBeanList =  HtGson.fromJson(resultStr, new TypeToken<List<CRMScheduleBean>>() {
        });
        if(cRMScheduleBeanList!=null&&cRMScheduleBeanList.size()>0) {
            List<CrmSchedule> crmSchedules = new ArrayList<CrmSchedule>();
            for (int i = 0; i < cRMScheduleBeanList.size(); i++) {
                CrmSchedule crmSchedule = new CrmSchedule();
                crmSchedule.setScheduleId(cRMScheduleBeanList.get(i).getID());
                crmSchedule.setSheduleTitle(cRMScheduleBeanList.get(i).getSHEDULE_TITLE());
                crmSchedule.setSenderId(cRMScheduleBeanList.get(i).getSENDER_ID());
                crmSchedule.setSenderName(cRMScheduleBeanList.get(i).getSENDER_NAME());
                crmSchedule.setProjectId(cRMScheduleBeanList.get(i).getPROJECT_ID());
                crmSchedule.setProjectName(cRMScheduleBeanList.get(i).getPROJECT_NAME());
                crmSchedule.setCustId(cRMScheduleBeanList.get(i).getCUST_ID());
                crmSchedule.setCustName(cRMScheduleBeanList.get(i).getCUST_NAME());
                crmSchedule.setContactId(cRMScheduleBeanList.get(i).getCONTACT_ID());
                crmSchedule.setContactName(cRMScheduleBeanList.get(i).getCONTACT_NAME());
                crmSchedule.setStartDate(cRMScheduleBeanList.get(i).getSTART_DATE());
                crmSchedule.setEndDate(cRMScheduleBeanList.get(i).getEND_DATE());
                crmSchedule.setMailFlag(cRMScheduleBeanList.get(i).getMAIL_FLAG());
                crmSchedule.setSmsFlag(cRMScheduleBeanList.get(i).getSMS_FLAG());
                crmSchedule.setSysmsgFlag(cRMScheduleBeanList.get(i).getSYSMSG_FLAG());
                crmSchedule.setMemo(cRMScheduleBeanList.get(i).getMEMO());
                crmSchedule.setVersion(cRMScheduleBeanList.get(i).getVERSION());
                crmSchedule.setReaminDate(cRMScheduleBeanList.get(i).getREAMIN_DATE());
                crmSchedule.setAlldayFlag(cRMScheduleBeanList.get(i).getALLDAY_FLAG());
                crmSchedule.setCreateDate(cRMScheduleBeanList.get(i).getCREATE_DATE());
                crmSchedule.setRemindType(cRMScheduleBeanList.get(i).getREMIND_TYPE());
                crmSchedule.setCaseId(cRMScheduleBeanList.get(i).getCASE_ID());
                crmSchedule.setCaseName(cRMScheduleBeanList.get(i).getCASE_NAME());
                crmSchedule.setCustType(cRMScheduleBeanList.get(i).getCUST_TYPE());
                crmSchedule.setSysmsgFlag(cRMScheduleBeanList.get(i).getIS_SYS_FLAG());
                crmSchedule.setRemainRate(cRMScheduleBeanList.get(i).getREAMIN_RATE());
                crmSchedule.setCanlStatus(cRMScheduleBeanList.get(i).getCANL_STATUS());
                crmSchedule.setConType(cRMScheduleBeanList.get(i).getCON_TYPE());
                crmSchedule.setProjType(cRMScheduleBeanList.get(i).getPROJ_TYPE());
                crmSchedule.setUserId(userId);
                crmSchedules.add(crmSchedule);
            }
            crmScheduleMapper.deleteAllByUserId(userId);
            result*=crmScheduleMapper.addCrmScheduleList(crmSchedules);
        }

        return result;
    }
}
