package com.ht.klinsurance.briefing.mapper;

import com.ht.klinsurance.briefing.model.BriefingLossImage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BriefingLossImageMapper {

    BriefingLossImage selectByPrimaryKey(String briefingLossImageId);

    /**
     * 根据损失项查询图片信息
     * @param lossId
     * @return
     */
    List<BriefingLossImage> findByLoss(String lossId);

    int addBriefingLossImage(BriefingLossImage record);

    int updateByPrimaryKeySelective(BriefingLossImage record);

    int deleteByPrimaryKey(String briefingLossImageId);

    int deleteByBriefingLossId(String briefingLossImageId);

}