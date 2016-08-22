package com.ht.klinsurance.loss.service;

import com.ht.klinsurance.loss.model.Loss;
import com.ht.klinsurance.loss.model.LossItem;

import java.util.List;

/**
 * *损失项
 * @author liuqi
 * @date 2016/7/23
 */
public interface ILossService {

    /**
     * 添加损失项
     * @param loss
     * @param itemList
     * @param picList
     * @return
     */
    int addLoss(Loss loss,List<LossItem> itemList);
}
