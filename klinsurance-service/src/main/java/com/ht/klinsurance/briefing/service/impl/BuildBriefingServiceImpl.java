package com.ht.klinsurance.briefing.service.impl;

import com.ht.klinsurance.briefing.mapper.BriefingLossImageMapper;
import com.ht.klinsurance.briefing.mapper.BriefingMapper;
import com.ht.klinsurance.briefing.model.Briefing;
import com.ht.klinsurance.briefing.model.BriefingLossImage;
import com.ht.klinsurance.briefing.service.IBuildBriefingService;
import com.ht.klinsurance.common.KlConsts;
import com.ht.klinsurance.common.WordUtils;
import com.ht.klinsurance.loss.mapper.LossMapper;
import com.ht.klinsurance.loss.model.Loss;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author feicy
 * @date 2016/8/17
 */
@Service
@Transactional
public class BuildBriefingServiceImpl implements IBuildBriefingService {
    @Resource
    private LossMapper lossMapper;
    @Resource
    private BriefingMapper briefingMapper;
    @Resource
    private BriefingLossImageMapper briefingLossImageMapper;
    @Override
    public String buildBriefing(String webPath,String briefingId) throws Exception{
        Map<String,Object> dataMap = new HashMap<>();
        Map<String,Object> param = new HashMap<>();

        //简报信息
        Briefing briefing = briefingMapper.findDetailInfo(briefingId);
        //Briefing briefing = briefingMapper.selectByPrimaryKey(briefingId);
        //损失项信息
        List<Loss> lossList = lossMapper.findByBriefing(briefingId);

        //图片信息
        List<Map<String,BriefingLossImage>> imageList = new ArrayList<>();
        for(Loss loss:lossList){
            //由于word模板损失项图片都是三个一行，为了满足要求，每个list里面放三条数据
          /*  List<LossItem> itemList = lossItemMapper.findByLoss(loss.getLossId());
            loss.setLossItems(itemList);*/

            List<BriefingLossImage> images = briefingLossImageMapper.findByLoss(loss.getBriefingLossId());

            Map<String,BriefingLossImage> tempImages ;
            for(int i=0;i<images.size();i++){
                tempImages= new HashMap<>();
                tempImages.put("info1",images.get(i));
                //生成要替换的图片信息
                param.put(images.get(i).getBriefingLossImageId(), addImageInfo(webPath,images.get(i)));

                for(int j=2;j<4;j++){
                    i++;
                    if(i<images.size()){
                        tempImages.put("info" + j, images.get(i));
                        //生成要替换的图片信息
                        param.put(images.get(i).getBriefingLossImageId(), addImageInfo(webPath,images.get(i)));
                    }else{
                        break;
                    }
                }
                imageList.add(tempImages);
            }
            loss.setBriefingLossImages(imageList);
        }
        //将相应信息放到集合里
        dataMap.put("briefing",briefing);
        dataMap.put("lossList", lossList);

        return WordUtils.createWord("简报模板.ftl", webPath, dataMap, param);
    }

    /**
     * 拼装替换图片信息
     * @param image
     * @return
     * @throws Exception
     */
    private Map<String,Object> addImageInfo(String webPath,BriefingLossImage image) throws Exception{
        Map<String,Object> header = new HashMap<String, Object>();
        header.put("width", KlConsts.WORD_IMAGE_WIDTH);
        header.put("height", KlConsts.WORD_IMAGE_HEIGHT);
        header.put("type", "png");
        header.put("content",
                WordUtils.inputStream2ByteArray(new FileInputStream(webPath+"/upload"+image.getImage()), true));

        return header;
    }
}
