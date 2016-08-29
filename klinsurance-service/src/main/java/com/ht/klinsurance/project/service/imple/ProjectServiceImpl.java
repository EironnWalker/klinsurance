package com.ht.klinsurance.project.service.imple;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.project.mapper.ProjectMapper;
import com.ht.klinsurance.project.model.Project;
import com.ht.klinsurance.project.service.IProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 项目信息
 *
 * @author liuqi
 * @date 2016/7/22
 */
@Service
@Transactional
public class ProjectServiceImpl implements IProjectService{

    @Resource
    private ProjectMapper projectMapper;

    @Override
    public List<Project> findProjectPageList(Map<String, Object> parameter, PageBounds pageBounds) {
        return projectMapper.findPageList(parameter,pageBounds);
    }
}
