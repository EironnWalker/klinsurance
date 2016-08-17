package com.ht.klinsurance.loss.mapper;

import com.ht.klinsurance.loss.model.LossItemHistoryPrice;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LossItemHistoryPriceMapper {
    int deleteByPrimaryKey(String historyPriceId);

    int deleteAll();

    int addLossItemHistoryPrice(List<LossItemHistoryPrice> list);

    LossItemHistoryPrice selectByPrimaryKey(String historyPriceId);

    int updateByPrimaryKeySelective(LossItemHistoryPrice record);
}