package com.ht.klinsurance.synce.action;

import com.ht.common.http.HtResponse;
import com.ht.klinsurance.common.BaseAction;
import com.ht.klinsurance.synce.ISynceDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 手动数据同步
 */
@Controller
@RequestMapping("synceAction")
public class SynceAction extends BaseAction
{
    @Resource
    private ISynceDataService synceDataService;


    @RequestMapping("synce")
    public void synce(String userJson, HttpServletResponse response) {
        try {
            synceDataService.synceUser();
            synceDataService.synceCustomer();
            synceDataService.synceLossItem();
            synceDataService. synceHistoryPriceInfo();
            HtResponse.outJson(response, true, "同步成功");
        } catch (Exception e) {
            log.error("登录主方法", e);
            HtResponse.outJson(response, false, "同步失败");
        }
    }

}
