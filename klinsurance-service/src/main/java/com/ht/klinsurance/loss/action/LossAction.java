package com.ht.klinsurance.loss.action;

import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.common.BaseAction;
import com.ht.klinsurance.loss.model.Loss;
import com.ht.klinsurance.loss.model.LossItem;
import com.ht.klinsurance.loss.service.ILossService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 损失项
 * @author liuqi
 * @date 2016/7/23
 */
@Controller
@RequestMapping("lossAction")
public class LossAction extends BaseAction
{

    @Resource
    private ILossService lossService;

    @RequestMapping("addLoss")
    public void addLoss(String lossJson,String lossItemJson, HttpServletResponse response) {
        try {
            Loss loss =  HtGson.fromJson(lossJson, new TypeToken<Loss>() {
            });
            List<LossItem>  lossItemList =  HtGson.fromJson(lossItemJson, new TypeToken<List<LossItem>>() {
            });
            //List<String> picList = HtGson.fromJson(picFileJson, new TypeToken<List<String>>() {
            //});
            int  result = lossService.addLoss(loss,lossItemList);
            if (result>0) {
                HtResponse.outJson(response, true, null);
            } else {
                HtResponse.outJson(response, false, null);
            }
        } catch (Exception e) {
            log.error("添加损失项", e);
        }
    }
}
