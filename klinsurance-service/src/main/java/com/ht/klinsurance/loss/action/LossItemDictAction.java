package com.ht.klinsurance.loss.action;

import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.common.BaseAction;
import com.ht.klinsurance.loss.model.LossItemDict;
import com.ht.klinsurance.synce.ISynceDataService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 损失项列表
 */
@Controller
@RequestMapping("lossItemDictAction")
public class LossItemDictAction extends BaseAction
{
    @Resource
    private ISynceDataService synceDataService;

    @RequestMapping("addLossItemDict")
    public void addLossItemDict(String lossItemDictJson, HttpServletResponse response) {
        try {
            LossItemDict loss =  HtGson.fromJson(lossItemDictJson, new TypeToken<LossItemDict>() {
            });

            loss = synceDataService.addLossItemDict(loss);
            if (loss!=null) {
                HtResponse.outJson(response, true, loss);
            } else {
                HtResponse.outJson(response, false, null);
            }
        } catch (Exception e) {
            log.error("添加损失项", e);
        }
    }
}

