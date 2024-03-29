package com.ht.klinsurance.briefing.action;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.ht.HtMap;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.briefing.model.Briefing;
import com.ht.klinsurance.briefing.model.BriefingLoss;
import com.ht.klinsurance.briefing.model.BriefingLossImage;
import com.ht.klinsurance.briefing.model.BriefingLossItem;
import com.ht.klinsurance.briefing.service.IBriefingService;
import com.ht.klinsurance.common.BaseAction;
import com.ht.klinsurance.common.KlConsts;
import com.ht.klinsurance.loss.model.Loss;
import com.ht.klinsurance.loss.model.LossItem;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 简报
 * @author liuqi
 * @date 2016/7/30
 */
@Controller
@RequestMapping("briefingAction")
public class BriefingAction extends BaseAction
{
    @Resource
    private IBriefingService briefingService;

    /**
     * 保存简报
     * @param briefingJson
     * @param briefingLossListJson
     * @param briefingLossItemJson
     * @param briefingLossImageListJson
     * @param lossListJson
     * @param lossItemListJson
     * @param response
     */
    @RequestMapping("addBriefing")
    public void addBriefing(String briefingJson,String briefingLossListJson,String briefingLossItemJson ,
                            String briefingLossImageListJson,String lossListJson,String lossItemListJson,
                            HttpServletResponse response,HttpServletRequest request)
    {
        try {
            Briefing briefing =  HtGson.fromJson(briefingJson, new TypeToken<Briefing>() {
            });
            List<BriefingLoss> briefingLossList =  HtGson.fromJson(briefingLossListJson, new TypeToken<List<BriefingLoss>>() {
            });
            List<BriefingLossItem> briefingLossItemList =  null;
            if(briefingLossItemJson!=null)
            {
                briefingLossItemList =  HtGson.fromJson(briefingLossItemJson,
                        new TypeToken<List<BriefingLossItem>>() {});
            }
            List<BriefingLossImage> briefingLossImageList =  null;
            if(briefingLossImageListJson!=null)
            {
                briefingLossImageList =  HtGson.fromJson(briefingLossImageListJson,
                        new TypeToken<List<BriefingLossImage>>() {});
            }
            List<Loss> lossList =   null;
            if(lossListJson!=null)
            {
                lossList =   HtGson.fromJson(lossListJson,new TypeToken<List<Loss>>() { });
            }
            List<LossItem> lossItemList = null;
            if(lossItemListJson!=null)
            {
                lossItemList = HtGson.fromJson(lossItemListJson,
                        new TypeToken<List<LossItem>>() {});
            }
            String   ftpUrl = briefingService.saveBriefing( briefing, briefingLossList, briefingLossItemList,
                    briefingLossImageList, lossList,lossItemList,request.getSession().getServletContext().getRealPath("/"));

            if (ftpUrl!=null) {
                HtResponse.outJson(response, true, ftpUrl);
            } else {
                HtResponse.outJson(response, false, null);
            }
        } catch (Exception e) {
            log.error("添加简报", e);
        }
    }
    @RequestMapping("test")
    public void test(HttpServletRequest request){
        String path=request.getSession().getServletContext().getRealPath("/");
        try {
            //String ftpUrl=buildBriefingService.buildBriefing(path,"4080cd0624f74f349bbed81727f5da70");
            //System.out.println("ftpUrl："+ftpUrl);
        } catch (Exception e) {
            log.error("测试生成简报", e);
        }
    }

    /**
     * 查看项目简报
     */
    @RequestMapping("findBriefingPageList")
    public void findBriefingPageList(String projectId,Integer limit,Integer pageNo,HttpServletRequest request, HttpServletResponse response){
        try {
            limit = limit == null ? KlConsts.PAGE_LIMIT : limit;
            HtMap htMap = new HtMap();
            if(StringUtils.isNotBlank(projectId)){
                htMap.put("projectId", projectId);
            }
            PageList<Briefing> textTemplateList = (PageList<Briefing>)briefingService
                    .findBriefingPageList(htMap, new PageBounds(pageNo, limit));
            HtResponse.outPageJson(response, true, textTemplateList);
        } catch (Exception e) {
            log.error("显示项目信息列表主方法", e);
        }
    }

}
