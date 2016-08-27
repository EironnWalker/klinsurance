package com.ht.klinsurance.project.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.project.model.Project;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ProjectMapper {

    /**
     * 查询项目详细信息
     * @param parameter
     * @return
     */
    List<Project> findPageList(Map<String, Object> parameter,PageBounds pageBounds);

    List<Project> findProjectByUserId(Map<String, Object> parameter);

    Project selectByPrimaryKey(String projectId);

    int addProject(Project record);

    int addProjectList(List<Project> list);

    int updateByPrimaryKeySelective(Project record);

    int deleteAll();

    int deleteByUserId(String userId);

    int deleteByPrimaryKey(String projectId);

}