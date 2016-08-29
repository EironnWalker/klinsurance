package com.ht.klinsurance.textTemplate.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.text.model.TextTemplate;

import java.util.List;

/**
 * 文字模板
 *
 * @author liuqi
 * @date 2016/7/23
 */
public interface ITextTemplateService {

    /**
     * 文字模板列表
     * @return
     */
    List<TextTemplate> findTextTemplateList(String search, String tagCode, PageBounds pageBounds);

    /**
     * 添加文字模板
     * @param textTemplate
     * @return
     */
    int addTexttemplate(TextTemplate textTemplate);

    /**
     * 更新文字模板
     * @param record
     * @return
     */
    int updateTextTemplate(TextTemplate record);

    /**
     * 删除文字模板
     * @param textTemplateId
     * @return
     */
    int deleteTextTemplateById(String textTemplateId);


}
