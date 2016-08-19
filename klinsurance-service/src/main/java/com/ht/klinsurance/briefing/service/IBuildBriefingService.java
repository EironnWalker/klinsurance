package com.ht.klinsurance.briefing.service;

/**
 * @author feicy
 * @date 2016/8/17
 */
public interface IBuildBriefingService {

    /**
     * 生成简报信息
     * @param webPath
     * @param briefingId
     */
    String buildBriefing(String webPath,String briefingId) throws Exception;
}

