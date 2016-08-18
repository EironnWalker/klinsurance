package com.ht.klinsurance.loss.service.imple;

import com.ht.klinsurance.common.FileUploadUtil;
import com.ht.klinsurance.loss.mapper.LossItemMapper;
import com.ht.klinsurance.loss.mapper.LossMapper;
import com.ht.klinsurance.loss.model.Loss;
import com.ht.klinsurance.loss.model.LossItem;
import com.ht.klinsurance.loss.service.ILossService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 损失项
 *
 * @author liuqi
 * @date 2016/7/23
 */
@Service
@Transactional
public class LossServiceImpl implements ILossService {

    @Resource
    private LossMapper lossMapper;
    @Resource
    private LossItemMapper lossItemMapper;

    /**
     * 添加损失项
     * @param loss
     * @param itemList
     * @param picList
     * @return
     */
    @Override
    public int addLoss(Loss loss, List<LossItem> itemList,List<String> picList)
    {

       String filePath =  FileUploadUtil.uploadFilePic(picList);
        loss.setCustomerSignPath(filePath);
         lossMapper.deleteByPrimaryKey(loss.getLossId());
        int result = 0;
         result*=lossMapper.addLoss(loss);
        result*=lossItemMapper.deleteBylossId(loss.getLossId());
        if(itemList!=null&&itemList.size()>0)
        {
            for(int i = 0;i<itemList.size();i++)
            {
                result*=lossItemMapper.addLossItem(itemList.get(i));
            }
        }
        return result;
    }


}
