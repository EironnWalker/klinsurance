package com.ht.klinsurance.textTemplate.action;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.common.BaseAction;
import com.ht.klinsurance.common.KlConsts;
import com.ht.klinsurance.text.model.TextTemplate;
import com.ht.klinsurance.textTemplate.service.ITextTemplateService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 文字模板
 * @author liuqi
 * @date 2016/7/23
 */
@Controller
@RequestMapping("textTemplateAction")
public class TextTemplateAction extends BaseAction {


    @Resource
    private ITextTemplateService textTemplateService;

    /**
     * 显示文字模板
     * @param name
     * @param response
     */
    @RequestMapping("findTextTemplate")
    public void findTextTemplate(String name,String tagCode,Integer limit,Integer pageNo, HttpServletResponse response) {
        try {
            limit = limit == null ? KlConsts.PAGE_LIMIT : limit;
            PageList<TextTemplate> textTemplateList = (PageList<TextTemplate>)textTemplateService
                    .findTextTemplateList(name, tagCode, new PageBounds(pageNo,limit));
            HtResponse.outPageJson(response, true, textTemplateList);
        } catch (Exception e) {
            log.error("显示文字模板列表主方法", e);
        }
    }

    /**
     * 添加文字模板
     * @param textTemplateJson
     * @param response
     */
    @RequestMapping("addTextTemplate")
    public void addTextTemplate(String textTemplateJson, HttpServletResponse response) {
        try {
            TextTemplate textTemplate =  HtGson.fromJson(textTemplateJson, new TypeToken<TextTemplate>() {});
            int result = textTemplateService.addTexttemplate(textTemplate);
            if (result>0) {
                HtResponse.outJson(response, true, result);
            } else {
                HtResponse.outJson(response, false, result);
            }
        } catch (Exception e) {
            log.error("文字模板添加主方法", e);
        }
    }

    /**
     * 添加文字模板
     * @param textTemplateJson
     * @param response
     */
    @RequestMapping("updateTextTemplate")
    public void updateTextTemplate(String textTemplateJson, HttpServletResponse response) {
        try {
            TextTemplate textTemplate =  HtGson.fromJson(textTemplateJson, new TypeToken<TextTemplate>() {});
            int result = textTemplateService.updateTextTemplate(textTemplate);
            if (result>0) {
                HtResponse.outJson(response, true, result);
            } else {
                HtResponse.outJson(response, false, result);
            }
        } catch (Exception e) {
            log.error("文字模板添加主方法", e);
        }
    }

    /**
     * 删除文字模板
     * @param textTemplateId
     * @param response
     */
    @RequestMapping("deleteTextTemplate")
    public void deleteTextTemplate(String textTemplateId, HttpServletResponse response) {
        try {
            int result = textTemplateService.deleteTextTemplateById(textTemplateId);
            if (result>0) {
                HtResponse.outJson(response, true, result);
            } else {
                HtResponse.outJson(response, false, result);
            }
        } catch (Exception e) {
            log.error("文字模板添加主方法", e);
        }
    }

}














