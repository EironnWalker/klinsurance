package com.ht.klinsurance.text.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.text.model.TextTemplate;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface TextTemplateMapper {

    /**
     * 查询文字模板列表
     * @param tagCodes
     * @return
     */
    List<TextTemplate> findList(@Param("search") String search,
                                @Param("tagCodes") String[] tagCodes,
                                @Param("pageBounds") PageBounds pageBounds);

    /**
     * 查询文字模板
     * @param textTemplateId
     * @return
     */
    TextTemplate findById(String textTemplateId);

    /**
     * 添加文字模板
     * @param record
     * @return
     */
    int addTextTemplate(TextTemplate record);

    /**
     * 更新文字模板
     * @param record
     * @return
     */
    int update(TextTemplate record);

    /**
     * 删除文字模板
     * @param textTemplateId
     * @return
     */
    int deleteByPrimaryKey(String textTemplateId);

    List<TextTemplate> findTextTemplateList(Map<String, Object> parameter);
}