package com.ht.klinsurance.loss.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.loss.model.LossItem;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LossItemMapper {

    LossItem selectByPrimaryKey(String lossItemId);

    List<LossItem> findLossItemPage(Map<String, Object> parameter, PageBounds pageBounds);

    /**
     * 根据损失项查询详情
     * @param lossId
     * @return
     */
    List<LossItem> findByLoss(String lossId);

    int addLossItem(LossItem record);

    int updateByPrimaryKeySelective(LossItem record);

    int deleteByPrimaryKey(String lossItemId);

    int deleteBylossId(String lossId);
}