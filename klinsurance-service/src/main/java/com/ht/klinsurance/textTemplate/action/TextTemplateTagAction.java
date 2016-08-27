package com.ht.klinsurance.textTemplate.action;


import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.common.BaseAction;
import com.ht.klinsurance.text.model.TextTemplateTag;
import com.ht.klinsurance.textTemplate.service.ITextTemplateTagService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 文字模板标签
 *
 * @author yiyk
 * @date 2016/8/25
 */
@Controller
@RequestMapping("textTemplateTagAction")
public class TextTemplateTagAction extends BaseAction {

    @Resource
    private ITextTemplateTagService textTemplateTagService;

    /**
     * 显示所有的文字模板标签
     *
     * @param response
     */
    @RequestMapping("findTextTemplateTag")
    public void findTextTemplateTag(HttpServletResponse response) {
        try {
            List<TextTemplateTag> textTemplateTags = textTemplateTagService.findTextTemplateTagAll();
            HtResponse.outJson(response, true, textTemplateTags);
        } catch (Exception e) {
            log.error("显示文字模板列表主方法", e);
        }
    }

    /**
     * 显示某个文字模板的标签
     *
     * @param response
     */
//    @RequestMapping("findTextTemplateTag")
//    public void findTextTemplateTagById(String tagCodes, HttpServletResponse response) {
//        try {
//            List<TextTemplateTag> textTemplateTags = textTemplateTagService.findTextTemplateTagById();
//            HtResponse.outJson(response, true, textTemplateTags);
//        } catch (Exception e) {
//            log.error("显示文字模板列表主方法", e);
//        }
//    }

    /**
     * 添加文字模板标签
     *
     * @param textTemplateTagJson
     * @param response
     */
    @RequestMapping("addTextTemplateTag")
    public void addTextTemplateTag(String textTemplateTagJson, HttpServletResponse response) {
        try {
            TextTemplateTag textTemplateTag = HtGson.fromJson(textTemplateTagJson, new TypeToken<TextTemplateTag>() {
            });
            int result = textTemplateTagService.addTextTemplateTag(textTemplateTag);
            if (result > 0) {
                HtResponse.outJson(response, true, result);
            } else {
                HtResponse.outJson(response, false, result);
            }
        } catch (Exception e) {
            log.error("文字模板标签添加主方法", e);
        }
    }

    /**
     * 修改文字模板标签
     *
     * @param textTemplateTagJson
     * @param response
     */
    @RequestMapping("updateTextTemplateTag")
    public void updateTextTemplateTag(String textTemplateTagJson, HttpServletResponse response) {
        try {
            TextTemplateTag textTemplateTag = HtGson.fromJson(textTemplateTagJson, new TypeToken<TextTemplateTag>() {
            });
            int result = textTemplateTagService.updateTextTemplateTag(textTemplateTag);
            if (result > 0) {
                HtResponse.outJson(response, true, result);
            } else {
                HtResponse.outJson(response, false, result);
            }
        } catch (Exception e) {
            log.error("文字模板修改主方法", e);
        }
    }

    /**
     * 删除文字模板标签
     *
     * @param textTemplateTagId
     * @param response
     */
    @RequestMapping("deleteTextTemplateTag")
    public void deleteTextTemplateTag(String textTemplateTagId, HttpServletResponse response) {
        try {
            int result = textTemplateTagService.deleteTextTemplateTagById(textTemplateTagId);
            if (result > 0) {
                HtResponse.outJson(response, true, result);
            } else {
                HtResponse.outJson(response, false, result);
            }
        } catch (Exception e) {
            log.error("文字模删除主方法", e);
        }
    }

}
