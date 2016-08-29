package com.ht.klinsurance.appVersion.action;

import com.ht.common.http.HtResponse;
import com.ht.klinsurance.appVersion.model.AppVersion;
import com.ht.klinsurance.appVersion.service.IAppVersionService;
import com.ht.klinsurance.common.BaseAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 查询版本控制
 */
@Controller
@RequestMapping("appVersionAction")
public class AppVersionAction extends BaseAction
{
    @Resource
    private IAppVersionService appVersionService;

    @RequestMapping("getAPPVersion")
    public void getAPPVersion(String appType,HttpServletResponse response,HttpServletRequest request)
    {
      try {
          AppVersion appVersion = appVersionService.getAppVersion(appType);
          if (appVersion!=null) {
              HtResponse.outJson(response, true, appVersion);
          } else {
              HtResponse.outJson(response, false, null);
          }
      }catch (Exception e)
      {
          log.error("查询版本控制", e);
          HtResponse.outJson(response, false, null);
      }
    }
}
