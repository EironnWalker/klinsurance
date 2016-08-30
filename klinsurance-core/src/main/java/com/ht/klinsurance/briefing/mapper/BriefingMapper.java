package com.ht.klinsurance.briefing.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.briefing.model.Briefing;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BriefingMapper {

    /**
     * 分页查询简报信息
     * @param pageBounds
     * @return
     */
    List<Briefing> findPageList(Map<String, Object> parameter, PageBounds pageBounds);

    Briefing selectByPrimaryKey(String briefingId);

    Briefing findDetailInfo(String briefingId);

    int addBriefing(Briefing record);

    int updateByPrimaryKeySelective(Briefing record);

    int deleteByPrimaryKey(String briefingId);
}