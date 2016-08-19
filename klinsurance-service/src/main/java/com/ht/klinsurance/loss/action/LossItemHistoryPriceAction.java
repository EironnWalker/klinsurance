package com.ht.klinsurance.loss.action;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ht.common.ht.HtMap;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.loss.model.LossItemHistoryPrice;
import com.ht.klinsurance.loss.service.ILossItemHistoryPriceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 历史损失项查询
 */
@Controller
@RequestMapping("lossItemHistoryPriceAction")
public class LossItemHistoryPriceAction
{
    @Resource
    private ILossItemHistoryPriceService lossItemHistoryPriceService;

    @RequestMapping("findlossItemHistoryPricePage")
    public void findlossItemHistoryPricePage(Integer page,String itemName, HttpServletResponse response) {
        try {
            HtMap htMap=new HtMap();
            if(StringUtils.isNotBlank(itemName)){
                htMap.put("itemName",itemName) ;
            }
            PageList<LossItemHistoryPrice> pageList = (PageList<LossItemHistoryPrice>)lossItemHistoryPriceService.findLossItemHistoryPricePage(htMap, new PageBounds(page, 10));
            HtResponse.outPageJson(response, true, pageList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
