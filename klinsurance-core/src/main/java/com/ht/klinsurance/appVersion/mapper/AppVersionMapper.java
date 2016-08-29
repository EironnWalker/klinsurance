package com.ht.klinsurance.appVersion.mapper;

import com.ht.klinsurance.appVersion.model.AppVersion;
import org.springframework.stereotype.Repository;

@Repository
public interface AppVersionMapper {
    int deleteByPrimaryKey(String appVersionId);

    int insertSelective(AppVersion record);

    AppVersion selectByAppType(String appType);

    int updateByPrimaryKeySelective(AppVersion record);
}