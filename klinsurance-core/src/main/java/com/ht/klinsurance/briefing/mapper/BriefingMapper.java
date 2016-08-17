package com.ht.klinsurance.briefing.mapper;

import com.ht.klinsurance.briefing.model.Briefing;
import org.springframework.stereotype.Repository;

@Repository
public interface BriefingMapper {
    int deleteByPrimaryKey(String briefingId);

    int addBriefing(Briefing record);

    Briefing selectByPrimaryKey(String briefingId);

    int updateByPrimaryKeySelective(Briefing record);

}