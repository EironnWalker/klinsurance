package com.ht.klinsurance.loss.mapper;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.loss.model.LossItemHistoryPrice;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LossItemHistoryPriceMapper {
    int deleteByPrimaryKey(String historyPriceId);

    int deleteAll();

    List<LossItemHistoryPrice> findLossItemHistoryPricePage(Map<String, Object> parameter, PageBounds pageBounds);

    int addLossItemHistoryPrice(List<LossItemHistoryPrice> list);

    LossItemHistoryPrice selectByPrimaryKey(String historyPriceId);

    int updateByPrimaryKeySelective(LossItemHistoryPrice record);
}