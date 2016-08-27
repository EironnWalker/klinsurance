package com.ht.klinsurance.appVersion.service;

import com.ht.klinsurance.appVersion.model.AppVersion;

/**
 * 版本控制
 */
public interface IAppVersionService
{
    /**
     * 查询版本
     * @param appType
     * @return
     */
    AppVersion getAppVersion(String appType);
}
