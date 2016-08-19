package com.ht.klinsurance.loss.service.imple;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.loss.mapper.LossItemHistoryPriceMapper;
import com.ht.klinsurance.loss.model.LossItemHistoryPrice;
import com.ht.klinsurance.loss.service.ILossItemHistoryPriceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class LossItemHistoryPriceServiceImpl implements ILossItemHistoryPriceService
{
    @Resource
    private LossItemHistoryPriceMapper lossItemHistoryPriceMapper;

    /**
     * 分页查询历史损失项
     *
     * @param parameter
     * @param pageBounds
     * @return
     */
    @Override
    public List<LossItemHistoryPrice> findLossItemHistoryPricePage(Map<String, Object> parameter, PageBounds pageBounds) {
        return lossItemHistoryPriceMapper.findLossItemHistoryPricePage(parameter,pageBounds);
    }
}
