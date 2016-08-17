package com.ht.klinsurance.briefing.mapper;

import com.ht.klinsurance.briefing.model.BriefingLossItem;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefingLossItemMapper {
    int deleteByPrimaryKey(String briefingLossItemId);

    int deleteByBriefingLossId(String briefingLossId);

    int adddBriefingLossItem(BriefingLossItem record);

    BriefingLossItem selectByPrimaryKey(String briefingLossItemId);

    int updateByPrimaryKeySelective(BriefingLossItem record);
}