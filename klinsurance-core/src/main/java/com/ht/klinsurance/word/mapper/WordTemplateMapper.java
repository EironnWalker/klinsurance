package com.ht.klinsurance.word.mapper;

import com.ht.klinsurance.word.model.WordTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface WordTemplateMapper {

    WordTemplate selectByPrimaryKey(String wordTemplateId);

    List<WordTemplate> findWordTemplateList(Map<String, Object> parameter);

    int insert(WordTemplate record);

    int insertSelective(WordTemplate record);

    int updateByPrimaryKeySelective(WordTemplate record);

    int deleteByPrimaryKey(String wordTemplateId);


}