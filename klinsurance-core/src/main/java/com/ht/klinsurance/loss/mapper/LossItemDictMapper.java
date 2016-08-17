package com.ht.klinsurance.loss.mapper;

import com.ht.klinsurance.loss.model.LossItemDict;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface LossItemDictMapper {
    int deleteByPrimaryKey(String lossItemDictId);

    int deleteAll();

    int addLossItemDict(LossItemDict record);

    int addLossItemDictList(List<LossItemDict> list);

    LossItemDict selectByPrimaryKey(String lossItemDictId);

    int updateByPrimaryKeySelective(LossItemDict record);

    List<LossItemDict> findLossItemDictList(Map<String, Object> parameter);
}