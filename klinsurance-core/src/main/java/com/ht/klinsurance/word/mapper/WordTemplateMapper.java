package com.ht.klinsurance.word.mapper;

import com.ht.klinsurance.word.model.WordTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface WordTemplateMapper {
    int deleteByPrimaryKey(String wordTemplateId);

    int insert(WordTemplate record);

    int insertSelective(WordTemplate record);

    WordTemplate selectByPrimaryKey(String wordTemplateId);

    int updateByPrimaryKeySelective(WordTemplate record);

    List<WordTemplate> findWordTemplateList(Map<String, Object> parameter);
}