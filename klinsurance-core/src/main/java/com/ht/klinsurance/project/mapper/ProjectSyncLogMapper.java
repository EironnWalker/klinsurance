package com.ht.klinsurance.project.mapper;

import com.ht.klinsurance.project.model.ProjectSyncLog;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectSyncLogMapper {
    int deleteByPrimaryKey(String projectSyncLogId);

    int addProjectSyncLog(ProjectSyncLog record);


    ProjectSyncLog selectByPrimaryKey(String projectSyncLogId);

    int updateByPrimaryKeySelective(ProjectSyncLog record);
}