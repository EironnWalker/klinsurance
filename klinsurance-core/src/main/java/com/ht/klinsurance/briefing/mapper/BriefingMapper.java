package com.ht.klinsurance.briefing.mapper;

import com.ht.klinsurance.briefing.model.Briefing;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefingMapper {

    Briefing selectByPrimaryKey(String briefingId);

    Briefing findDetailInfo(String briefingId);

    int addBriefing(Briefing record);

    int updateByPrimaryKeySelective(Briefing record);

    int deleteByPrimaryKey(String briefingId);
}