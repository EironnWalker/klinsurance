package com.ht.klinsurance.textTemplate.action;

import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.common.BaseAction;
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
     * 添加文字模板
     * @param textTemplateJson
     * @param response
     */
    @RequestMapping("addTextTemplate")
    public void addTextTemplate(String textTemplateJson, HttpServletResponse response) {
        try {

            TextTemplate textTemplate =  HtGson.fromJson(textTemplateJson, new TypeToken<TextTemplate>() {
            });
            int result = textTemplateService.addTexttemplate(textTemplate);
            if (result>0) {
                HtResponse.outJson(response, true, null);
            } else {
                HtResponse.outJson(response, false, null);
            }
        } catch (Exception e) {
            log.error("文字模板添加主方法", e);
        }
    }
}
