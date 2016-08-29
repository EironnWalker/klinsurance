package com.ht.klinsurance.textTemplate.service;

import com.ht.klinsurance.text.model.TextTemplateTag;

import java.util.List;

/**
 * 文字模板标签
 * yiyk
 */
public interface ITextTemplateTagService {

    /**
     * 查找所有的用户标签
     * @return
     */
    List<TextTemplateTag> findTextTemplateTagAll();

    /**
     * 查找某个用户的标签
     * @return
     */
//    List<TextTemplateTag> findTextTemplateTagById();

    /**
     * 添加用户标签
     * @param record
     * @return
     */
    int addTextTemplateTag(TextTemplateTag record);

    /**
     * 更新文字模板标签
     * @param record
     * @return
     */
    int updateTextTemplateTag(TextTemplateTag record);

    /**
     * 删除文字模板标签
     * @param textTemplateTagId
     * @return
     */
    int deleteTextTemplateTagById(String textTemplateTagId);

}
