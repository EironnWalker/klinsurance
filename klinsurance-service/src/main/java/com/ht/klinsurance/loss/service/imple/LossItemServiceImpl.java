package com.ht.klinsurance.loss.service.imple;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.ht.klinsurance.loss.mapper.LossItemMapper;
import com.ht.klinsurance.loss.model.LossItem;
import com.ht.klinsurance.loss.service.ILossItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 损失项
 *
 * @author liuqi
 * @date 2016/8/3
 */
@Service
@Transactional
public class LossItemServiceImpl implements ILossItemService {
    @Resource
    private LossItemMapper lossItemMapper;
    /**
     * 分页查询
     *
     * @param parameter
     * @param pageBounds
     * @return
     */
    @Override
    public List<LossItem> findLossItemPage(Map<String, Object> parameter, PageBounds pageBounds)
    {
        return lossItemMapper.findLossItemPage(parameter,pageBounds);
    }
}
