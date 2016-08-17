package com.ht.klinsurance.loss.mapper;

import com.ht.klinsurance.loss.model.Loss;
import org.springframework.stereotype.Repository;

@Repository
public interface LossMapper {
    Loss selectByPrimaryKey(String lossId);

    int addLoss(Loss record);

    int updateByPrimaryKeySelective(Loss record);

    int deleteByPrimaryKey(String lossId);
}