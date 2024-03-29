package com.ht.klinsurance.briefing.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.briefing.model.Briefing;
import com.ht.klinsurance.briefing.model.BriefingLoss;
import com.ht.klinsurance.briefing.model.BriefingLossImage;
import com.ht.klinsurance.briefing.model.BriefingLossItem;
import com.ht.klinsurance.loss.model.Loss;
import com.ht.klinsurance.loss.model.LossItem;

import java.util.List;
import java.util.Map;

/**
 * 简报
 * @author liuqi
 * @date 2016/7/29
 */
public interface IBriefingService {

    /**
     * 保存简报
     * @param briefing
     * @param briefingLossList
     * @param briefingLossItemList
     * @param briefingLossImageList
     * @param lossList
     * @param lossItemList
     * @return
     */
    String saveBriefing(Briefing briefing,List<BriefingLoss> briefingLossList,List<BriefingLossItem> briefingLossItemList,
                     List<BriefingLossImage> briefingLossImageList,List<Loss> lossList,List<LossItem> lossItemList,String path);


    /**
     * 分页查询项目简报
     * @param parameter
     * @param pageBounds
     * @return
     */
    List<Briefing> findBriefingPageList(Map<String, Object> parameter,PageBounds pageBounds);


}
