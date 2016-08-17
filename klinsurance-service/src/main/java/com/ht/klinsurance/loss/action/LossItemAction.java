package com.ht.klinsurance.loss.action;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.ht.common.ht.HtMap;
import com.ht.common.http.HtResponse;
import com.ht.klinsurance.loss.model.LossItem;
import com.ht.klinsurance.loss.service.ILossItemService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * 损失项
 * @author liuqi
 * @date 2016/8/3
 */
@Controller
@RequestMapping("lossItemAction")
public class LossItemAction {
    @Resource
    private ILossItemService lossItemService;

    /**
     * 分页查看损失项历史
     * @param page
     * @param itemName
     * @param response
     */
    @RequestMapping("findLossItemPage")
    public void findLossItemPage(Integer page,String itemName, HttpServletResponse response) {
        try {
            HtMap htMap=new HtMap();
            if(StringUtils.isNotBlank(itemName)){
                htMap.put("itemName",itemName) ;
            }
            PageList<LossItem> pageList = (PageList<LossItem>)lossItemService.findLossItemPage(htMap, new PageBounds(page, 10));
            HtResponse.outPageJson(response, true, pageList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
