package com.ht.klinsurance.loss.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.loss.model.LossItem;

import java.util.List;
import java.util.Map;

/**
 * s损失项
 */
public interface ILossItemService {

    /**
     * 分页查询
     * @param parameter
     * @param pageBounds
     * @return
     */
    List<LossItem> findLossItemPage(Map<String, Object> parameter, PageBounds pageBounds);
}
