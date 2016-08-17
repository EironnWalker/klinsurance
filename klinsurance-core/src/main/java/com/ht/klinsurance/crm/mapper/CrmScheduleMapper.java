package com.ht.klinsurance.crm.mapper;

import com.ht.klinsurance.crm.model.CrmSchedule;

import java.util.List;

public interface CrmScheduleMapper {
    int deleteByPrimaryKey(String scheduleId);

    int deleteAllByUserId(String userId);
    int insertSelective(CrmSchedule record);

    int addCrmScheduleList(List<CrmSchedule> list);

    CrmSchedule selectByPrimaryKey(String scheduleId);

    int updateByPrimaryKeySelective(CrmSchedule record);
}