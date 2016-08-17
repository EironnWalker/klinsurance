package com.ht.klinsurance.briefing.mapper;

import com.ht.klinsurance.briefing.model.BriefingLossImage;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefingLossImageMapper {
    int deleteByPrimaryKey(String briefingLossImageId);

    int deleteByBriefingLossId(String briefingLossImageId);

    int addBriefingLossImage(BriefingLossImage record);

    BriefingLossImage selectByPrimaryKey(String briefingLossImageId);

    int updateByPrimaryKeySelective(BriefingLossImage record);

}