package com.ht.klinsurance.text.mapper;

import com.ht.klinsurance.text.model.TextTemplateTag;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TextTemplateTagMapper {
    int deleteByPrimaryKey(String textTemplateTagId);

    int insertSelective(TextTemplateTag record);

    TextTemplateTag selectByPrimaryKey(String textTemplateTagId);

    int updateByPrimaryKeySelective(TextTemplateTag record);

    List<TextTemplateTag> findTextTemplateTagList(Map<String, Object> parameter );
}