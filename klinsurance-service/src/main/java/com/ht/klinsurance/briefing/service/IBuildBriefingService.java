package com.ht.klinsurance.briefing.service;

/**
 * @author feicy
 * @date 2016/8/17
 */
public interface IBuildBriefingService {

    /**
     * 生成简报信息
     * @param briefingId
     */
    void buildBriefing(String briefingId) throws Exception;
}

