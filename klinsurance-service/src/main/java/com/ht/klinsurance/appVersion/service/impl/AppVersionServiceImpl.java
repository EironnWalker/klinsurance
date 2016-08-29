package com.ht.klinsurance.appVersion.service.impl;

import com.ht.klinsurance.appVersion.mapper.AppVersionMapper;
import com.ht.klinsurance.appVersion.model.AppVersion;
import com.ht.klinsurance.appVersion.service.IAppVersionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class AppVersionServiceImpl implements IAppVersionService {
    @Resource
    private AppVersionMapper appVersionMapper;
    /**
     * 查询版本
     *
     * @param appType
     * @return
     */
    @Override
    public AppVersion getAppVersion(String appType) {
        return appVersionMapper.selectByAppType(appType);
    }
}
