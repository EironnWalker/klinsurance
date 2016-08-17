package com.ht.klinsurance.project.mapper;

import com.ht.klinsurance.project.model.Project;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProjectMapper {
    int deleteByPrimaryKey(String projectId);

    int deleteAll();

    int deleteByUserId(String userId);

    int addProject(Project record);

    int addProjectList(List<Project> list);

    Project selectByPrimaryKey(String projectId);

    int updateByPrimaryKeySelective(Project record);

    List<Project> findProjectByUserId(Map<String, Object> parameter);

}