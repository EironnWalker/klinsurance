package com.ht.klinsurance.project.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.project.model.Project;

import java.util.List;
import java.util.Map;

/**
 *
 *项目信息
 * @author liuqi
 * @date 2016/7/22
 */
public interface IProjectService {

    /**
     * 分页查询项目信息
     * @param parameter
     * @param pageBounds
     * @return
     */
    List<Project> findProjectPageList(Map<String, Object> parameter,PageBounds pageBounds);

}
