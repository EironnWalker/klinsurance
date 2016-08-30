package com.ht.klinsurance.project.action;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ht.common.ht.HtMap;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.common.BaseAction;
import com.ht.klinsurance.common.KlConsts;
import com.ht.klinsurance.project.model.Project;
import com.ht.klinsurance.project.service.IProjectService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 项目信息
 * @author yiyk
 * @date 2016/8/27
 */
@Controller
@RequestMapping("projectAction")
public class ProjectAction extends BaseAction {

    @Resource
    private IProjectService projectService;

    /**
     * 显示项目信息
     * @param projectName
     * @param response
     */
    @RequestMapping("findProjectPageList")
    public void findProjectPageList(String projectName,Integer limit,Integer pageNo, HttpServletResponse response) {
        try {
            limit = limit == null ? KlConsts.PAGE_LIMIT : limit;
            HtMap htMap = new HtMap();
            if(StringUtils.isNotBlank(projectName)){
                htMap.put("projectName",projectName);
            }
            PageList<Project> textTemplateList = (PageList<Project>)projectService
                    .findProjectPageList(htMap, new PageBounds(pageNo, limit));
            HtResponse.outPageJson(response, true, textTemplateList);
        } catch (Exception e) {
            log.error("显示项目信息列表主方法", e);
        }
    }

    /**
     * 查找World下载路径
     * @param response
     */
    @RequestMapping("findWorldUrl")
    public void findWorldUrl(HttpServletRequest request, HttpServletResponse response ){
        String path=request.getSession().getServletContext().getRealPath("/");
        System.out.println("======================"+path);
        HtResponse.outJson(response, true, path);
    }

}
