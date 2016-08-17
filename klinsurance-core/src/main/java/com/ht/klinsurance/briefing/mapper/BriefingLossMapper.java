package com.ht.klinsurance.briefing.mapper;

import com.ht.klinsurance.briefing.model.BriefingLoss;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefingLossMapper {
    int deleteByPrimaryKey(String briefingLossId);


    int addBriefingLoss(BriefingLoss record);

    BriefingLoss selectByPrimaryKey(String briefingLossId);

    int updateByPrimaryKeySelective(BriefingLoss record);

}