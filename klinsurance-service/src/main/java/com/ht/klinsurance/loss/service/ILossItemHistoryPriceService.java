package com.ht.klinsurance.loss.service;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.loss.model.LossItemHistoryPrice;

import java.util.List;
import java.util.Map;

/**
 * 历史损失项查询
 *
 * @author lindp
 * @date 2016/8/18
 */
public interface ILossItemHistoryPriceService {

    /**
     * 分页查询历史损失项
     * @param parameter
     * @param pageBounds
     * @return
     */

    List<LossItemHistoryPrice> findLossItemHistoryPricePage(Map<String, Object> parameter, PageBounds pageBounds);
}
