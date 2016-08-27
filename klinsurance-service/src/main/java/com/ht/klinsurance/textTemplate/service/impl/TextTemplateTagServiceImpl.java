package com.ht.klinsurance.textTemplate.service.impl;

import com.ht.common.utils.UUIDGenerate;
import com.ht.klinsurance.text.mapper.TextTemplateTagMapper;
import com.ht.klinsurance.text.model.TextTemplateTag;
import com.ht.klinsurance.textTemplate.service.ITextTemplateTagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TextTemplateTagServiceImpl implements ITextTemplateTagService {

    @Resource
    private TextTemplateTagMapper textTemplateTagMapper;

    @Override
    public List<TextTemplateTag> findTextTemplateTagAll() {
        return textTemplateTagMapper.findAll();
    }

//    @Override
//    public List<TextTemplateTag> findTextTemplateTagById() {
//        return null;
//    }

    @Override
    public int addTextTemplateTag(TextTemplateTag textTemplateTag) {
        String maxCode = textTemplateTagMapper.findTagMax();
        maxCode = String.valueOf(Integer.parseInt(maxCode) + 1);
        textTemplateTag.setTextTemplateTagId(UUIDGenerate.generate());
        textTemplateTag.setCreateTime(new Date());
        textTemplateTag.setCode(maxCode);
        return textTemplateTagMapper.add(textTemplateTag);
    }

    @Override
    public int updateTextTemplateTag(TextTemplateTag textTemplateTag) {
        return textTemplateTagMapper.update(textTemplateTag);
    }

    @Override
    public int deleteTextTemplateTagById(String textTemplateTagId) {
        return textTemplateTagMapper.deleteById(textTemplateTagId);
    }
}
