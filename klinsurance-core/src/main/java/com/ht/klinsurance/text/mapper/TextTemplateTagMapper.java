package com.ht.klinsurance.text.mapper;

import com.ht.klinsurance.text.model.TextTemplateTag;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TextTemplateTagMapper {

    /**
     * 查找所有的用户标签
     * @return
     */
    List<TextTemplateTag> findAll();

    /**
     * 查询文字模板标签
     * @param textTemplateTagId
     * @return
     */
    TextTemplateTag findById(String textTemplateTagId);

    /**
     * 查询最大的标签
     * @return
     */
    String findTagMax();


    List<TextTemplateTag> findTextTemplateTagList(Map<String, Object> parameter );

    /**
     * 添加用户标签
     * @param record
     * @return
     */
    int add(TextTemplateTag record);

    /**
     * 更新文字模板标签
     * @param record
     * @return
     */
    int update(TextTemplateTag record);

    /**
     * 删除文字模板标签
     * @param textTemplateTagId
     * @return
     */
    int deleteById(String textTemplateTagId);

}