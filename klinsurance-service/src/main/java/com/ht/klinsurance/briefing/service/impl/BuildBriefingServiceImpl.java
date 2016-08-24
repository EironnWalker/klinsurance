package com.ht.klinsurance.briefing.service.impl;

import com.ht.klinsurance.briefing.mapper.BriefingLossImageMapper;
import com.ht.klinsurance.briefing.mapper.BriefingMapper;
import com.ht.klinsurance.briefing.model.Briefing;
import com.ht.klinsurance.briefing.model.BriefingLossImage;
import com.ht.klinsurance.briefing.service.IBuildBriefingService;
import com.ht.klinsurance.common.WordUtils;
import com.ht.klinsurance.loss.mapper.LossMapper;
import com.ht.klinsurance.loss.model.Loss;
import com.ht.klinsurance.word.mapper.WordTemplateMapper;
import com.ht.klinsurance.word.model.WordTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Resource
    private WordTemplateMapper wordTemplateMapper;
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
        List<Map<String,BriefingLossImage>> imageList;
        for(Loss loss:lossList){
            imageList = new ArrayList<>();
            //由于word模板损失项图片都是三个一行，为了满足要求，每个list里面放三条数据
          /*  List<LossItem> itemList = lossItemMapper.findByLoss(loss.getLossId());
            loss.setLossItems(itemList);*/

            List<BriefingLossImage> images = briefingLossImageMapper.findByLoss(loss.getBriefingLossId());

            Map<String,BriefingLossImage> tempImages ;
            for(int i=0;i<images.size();i++){
                tempImages= new HashMap<>();
                tempImages.put("info1",images.get(i));
                if( new File(webPath+"upload/"+ images.get(i).getImage()).exists()){
                    //生成要替换的图片信息
                    param.put(images.get(i).getBriefingLossImageId(), WordUtils.addImageInfo(webPath, images.get(i)));
                }
                for(int j=2;j<4;j++){
                    i++;
                    if(i<images.size()){
                        tempImages.put("info" + j, images.get(i));
                        if( new File(webPath+"upload/"+ images.get(i).getImage()).exists()){
                            //生成要替换的图片信息
                            param.put(images.get(i).getBriefingLossImageId(), WordUtils.addImageInfo(webPath, images.get(i)));
                        }
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
        //获取模板
        WordTemplate template=wordTemplateMapper.selectByPrimaryKey(briefing.getWordTemplateId());

        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String path="upload/word/"+briefing.getProjectId()+"/jianbao-"+briefingId+"-"+format.format(new Date());

        WordUtils.createWord(template.getName(), webPath+path, dataMap, param);

        return path+".docx";
    }

}
