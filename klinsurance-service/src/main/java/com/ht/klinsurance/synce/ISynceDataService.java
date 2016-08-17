package com.ht.klinsurance.synce;

import com.ht.klinsurance.loss.model.LossItemDict;

/**
 * 数据同步接口
 *
 * @author lindp
 * @date 2016/8/12
 */
public interface ISynceDataService {
    /**
     * t同步用户信息
     * @return
     */
    int synceUser();

    /**
     * 同步客户信息
     * @return
     */
    int synceCustomer();

    /**
     * 同步项目信息
     * @return
     */
    int synceProject();
    /**
     * 同步项目信息
     * @param userId
     * @return
     */
    int synceProjectByUserId(String userId);

    /**
     * 同步损失项信息
     * @return
     */
    int synceLossItem();

    /**
     * 同步项目与用户关系
     * @return
     */
    int synceProjectUser();

    /**
     * 根据用户id查询项目与用户关系
     * @param userId
     * @return
     */
    int synceProjectUserByUserId(String userId);
    /**
     * 同步历史损失项信息
     * @return
     */
    int synceHistoryPriceInfo();

    /**
     * 增加损失项接口
     * @param lossItemDict
     * @return
     */
    int addLossItemDict(LossItemDict lossItemDict);

}
