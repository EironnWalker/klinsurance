package com.ht.klinsurance.project.mapper;

import com.ht.klinsurance.project.model.ProjectUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectUserMapper {
    int deleteByPrimaryKey(String projectUserId);

    int deleteAll();

    int deleteByUserId(String userId);
    int addProjectUser(List<ProjectUser> list);

    ProjectUser selectByPrimaryKey(String projectUserId);

    int updateByPrimaryKeySelective(ProjectUser record);
}