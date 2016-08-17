package com.ht.klinsurance.crm.mapper;

import com.ht.klinsurance.crm.model.CrmProject;

import java.util.List;

public interface CrmProjectMapper {
    int deleteByPrimaryKey(String projectId);

    int deleteByUserId(String userId);

    int insertSelective(CrmProject record);

    int  addCrmProjectList(List<CrmProject> list);

    int updateByPrimaryKeySelective(CrmProject record);
}