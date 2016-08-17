package com.ht.klinsurance.textTemplate.service;

import com.ht.klinsurance.text.model.TextTemplate;

/**
 * 文字模板
 *
 * @author liuqi
 * @date 2016/7/23
 */
public interface ITextTemplateService {

    /**
     * 添加文字模板
     * @param textTemplate
     * @return
     */
    int addTexttemplate(TextTemplate textTemplate);
}
