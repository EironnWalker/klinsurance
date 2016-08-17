package com.ht.klinsurance.loss.mapper;

import com.ht.klinsurance.loss.model.Loss;
import org.springframework.stereotype.Repository;

@Repository
public interface LossMapper {
    int deleteByPrimaryKey(String lossId);

    int addLoss(Loss record);

    Loss selectByPrimaryKey(String lossId);

    int updateByPrimaryKeySelective(Loss record);
}