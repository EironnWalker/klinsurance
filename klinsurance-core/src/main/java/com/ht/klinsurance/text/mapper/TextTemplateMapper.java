package com.ht.klinsurance.text.mapper;

import com.ht.klinsurance.text.model.TextTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TextTemplateMapper {
    int deleteByPrimaryKey(String textTemplateId);

    int addTextTemplate(TextTemplate record);

    TextTemplate selectByPrimaryKey(String textTemplateId);

    int updateByPrimaryKeySelective(TextTemplate record);

    List<TextTemplate> findTextTemplateList(Map<String, Object> parameter);
}