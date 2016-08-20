package com.ht.klinsurance.loss.mapper;

import com.ht.klinsurance.loss.model.Loss;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LossMapper {

    Loss selectByPrimaryKey(String lossId);

    /**
     * 根据简报获取定损项信息
     * @param briefingId
     * @return
     */
    List<Loss> findByBriefing(String briefingId);
    /**
     * 根据报告获取定损项信息
     * @param reportId
     * @return
     */
    List<Loss> findByReport(String reportId);

    int addLoss(Loss record);

    int updateByPrimaryKeySelective(Loss record);

    int deleteByPrimaryKey(String lossId);
}