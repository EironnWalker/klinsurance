package com.ht.klinsurance.briefing.service.impl;

import com.ht.klinsurance.briefing.mapper.BriefingLossImageMapper;
import com.ht.klinsurance.briefing.mapper.BriefingLossItemMapper;
import com.ht.klinsurance.briefing.mapper.BriefingLossMapper;
import com.ht.klinsurance.briefing.mapper.BriefingMapper;
import com.ht.klinsurance.briefing.model.Briefing;
import com.ht.klinsurance.briefing.model.BriefingLoss;
import com.ht.klinsurance.briefing.model.BriefingLossImage;
import com.ht.klinsurance.briefing.model.BriefingLossItem;
import com.ht.klinsurance.briefing.service.IBriefingService;
import com.ht.klinsurance.loss.mapper.LossItemMapper;
import com.ht.klinsurance.loss.mapper.LossMapper;
import com.ht.klinsurance.loss.model.Loss;
import com.ht.klinsurance.loss.model.LossItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 简报
 * @author liuqi
 * @date 2016/7/29
 */
@Service
@Transactional
public class BriefingServiceImpl implements IBriefingService {

    @Resource
    private LossMapper lossMapper;
    @Resource
    private LossItemMapper lossItemMapper;
    @Resource
    private BriefingMapper briefingMapper;
    @Resource
    private BriefingLossMapper briefingLossMapper;
    @Resource
    private BriefingLossItemMapper briefingLossItemMapper;
    @Resource
    private BriefingLossImageMapper briefingLossImageMapper;

    /**
     * 保存简报
     *
     * @param briefing
     * @param briefingLossList
     * @param briefingLossItemList
     * @param briefingLossImageList
     * @param lossList
     * @param lossItemList
     * @return
     */
    @Override
    public int saveBriefing(Briefing briefing, List<BriefingLoss> briefingLossList, List<BriefingLossItem> briefingLossItemList,
                            List<BriefingLossImage> briefingLossImageList, List<Loss> lossList, List<LossItem> lossItemList)
    {
        //首先判断简报是否存在如果存在则删除再新建，如果不存在这新建
        briefingMapper.deleteByPrimaryKey(briefing.getBriefingId());
        briefingMapper.addBriefing(briefing);
        //BriefingLoss 如果存在则删除再新建 不存在则新建
        if(briefingLossList!=null)
        {
            for(int i =0;i<briefingLossList.size();i++)
            {
                briefingLossMapper.deleteByPrimaryKey(briefingLossList.get(i).getBriefingLossId());
                briefingLossMapper.addBriefingLoss(briefingLossList.get(i));

                //briefingLossItemList 为了方便起见，先清空再重新插入
                briefingLossItemMapper.deleteByBriefingLossId(briefingLossList.get(i).getBriefingLossId());

                //briefingLossImageList 为了方便起见，先清空再重新插入
                briefingLossImageMapper.deleteByBriefingLossId(briefingLossList.get(i).getBriefingLossId());
            }
        }

        if(briefingLossItemList!=null&&briefingLossItemList.size()>0)
        {
            for(int i = 0; i<briefingLossItemList.size();i++)
            {
                briefingLossItemMapper.adddBriefingLossItem(briefingLossItemList.get(i));
            }
        }
        if(briefingLossImageList!=null&&briefingLossImageList.size()>0)
        {
            for(int i = 0; i<briefingLossImageList.size();i++)
            {
//                //处理图片 图片已经在发图片处理
//                List<String>originalImagelist =  new ArrayList<String>();
//                originalImagelist.add(briefingLossImageList.get(i).getOriginalImage());
//                String originalImagePath = FileUploadUtil.uploadFilePic(originalImagelist);
//                briefingLossImageList.get(i).setOriginalImage(originalImagePath);
//
//                List<String> imagelist =  new ArrayList<String>();
//                imagelist.add(briefingLossImageList.get(i).getImage());
//                String imagePath = FileUploadUtil.uploadFilePic(imagelist);
//                briefingLossImageList.get(i).setImage(imagePath);
                briefingLossImageMapper.addBriefingLossImage(briefingLossImageList.get(i));
            }
        }
        //loss 插入或者更新
        if(lossList!=null)
        {
            for(int i= 0;i<lossList.size();i++) {
                lossMapper.deleteByPrimaryKey(lossList.get(i).getLossId());
                lossMapper.addLoss(lossList.get(i));
            }
        }
        //lossItemList为了确保信息的准确性，只能是更新或者插入，不能全部删掉
        if(lossItemList!=null)
        {
            for(int i= 0;i<lossItemList.size();i++)
            {
                lossItemMapper.deleteByPrimaryKey(lossItemList.get(i).getLossItemId());
                lossItemMapper.addLossItem(lossItemList.get(i));
            }
        }
        //TODO 生成简报，如果损失项，地点等信息不存在则提示先同步数据




        return 0;
    }
}
