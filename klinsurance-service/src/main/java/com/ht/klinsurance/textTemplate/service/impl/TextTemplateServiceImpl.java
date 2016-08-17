package com.ht.klinsurance.textTemplate.service.impl;

import com.ht.klinsurance.text.mapper.TextTemplateMapper;
import com.ht.klinsurance.text.model.TextTemplate;
import com.ht.klinsurance.textTemplate.service.ITextTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 文字模板
 *
 * @author liuqi
 * @date 2016/7/23
 */
@Service
@Transactional
public class TextTemplateServiceImpl  implements ITextTemplateService{

    @Resource
    private TextTemplateMapper textTemplateMapper;
    /**
     * 添加文字模板
     *
     * @param textTemplate
     * @return
     */
    @Override
    public int addTexttemplate(TextTemplate textTemplate) {

        return textTemplateMapper.addTextTemplate(textTemplate);
    }
}
