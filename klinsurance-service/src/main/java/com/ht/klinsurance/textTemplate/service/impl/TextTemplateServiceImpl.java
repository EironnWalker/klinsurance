package com.ht.klinsurance.textTemplate.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.common.utils.UUIDGenerate;
import com.ht.klinsurance.text.mapper.TextTemplateMapper;
import com.ht.klinsurance.text.model.TextTemplate;
import com.ht.klinsurance.textTemplate.service.ITextTemplateService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
     * 查询文字模板列表
     * @param search
     * @param tagCode
     * @return
     */
    public List<TextTemplate> findTextTemplateList(String search, String tagCode,PageBounds pageBounds){
        String[] tagCodes = null;
        if(StringUtils.isNotBlank(tagCode)){
            tagCodes = tagCode.split(",");
        }
        return textTemplateMapper.findList(search,tagCodes,pageBounds);
    }

    /**
     * 添加文字模板
     * @param textTemplate
     * @return
     */
    @Override
    public int addTexttemplate(TextTemplate textTemplate) {
        textTemplate.setTextTemplateId(UUIDGenerate.generate());
        textTemplate.setCreateTime(new Date());
        return textTemplateMapper.addTextTemplate(textTemplate);
    }

    @Override
    public int updateTextTemplate(TextTemplate record) {
        return textTemplateMapper.update(record);
    }

    @Override
    public int deleteTextTemplateById(String textTemplateId) {
        return textTemplateMapper.deleteByPrimaryKey(textTemplateId);
    }

}
