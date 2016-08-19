package com.ht.klinsurance.report.service.impl;

import com.ht.klinsurance.briefing.mapper.BriefingLossImageMapper;
import com.ht.klinsurance.briefing.model.BriefingLossImage;
import com.ht.klinsurance.common.KlConsts;
import com.ht.klinsurance.common.WordUtils;
import com.ht.klinsurance.loss.mapper.LossItemMapper;
import com.ht.klinsurance.loss.mapper.LossMapper;
import com.ht.klinsurance.loss.model.Loss;
import com.ht.klinsurance.loss.model.LossItem;
import com.ht.klinsurance.report.mapper.ReportMapper;
import com.ht.klinsurance.report.model.Report;
import com.ht.klinsurance.report.service.IBuildReportService;
import com.ht.klinsurance.word.mapper.WordTemplateMapper;
import com.ht.klinsurance.word.model.WordTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author feicy
 * @date 2016/8/19
 */
@Service
@Transactional
public class BuildReportServiceImpl implements IBuildReportService {

    @Resource
    private ReportMapper reportMapper;
    @Resource
    private LossMapper lossMapper;
    @Resource
    private LossItemMapper lossItemMapper;
    @Resource
    private BriefingLossImageMapper briefingLossImageMapper;
    @Resource
    private WordTemplateMapper wordTemplateMapper;
    @Override
    public String buildReport(String webPath,String reportId) throws Exception{
        Map<String,Object> dataMap = new HashMap<>();
        Map<String,Object> param = new HashMap<>();

        Report report = reportMapper.findDetail(reportId);

        //损失项信息
        List<Loss> lossList = lossMapper.findByReport(reportId);

        //图片信息
        List<Map<String,BriefingLossImage>>imageList;
        for(Loss loss:lossList){
            imageList = new ArrayList<>();
            //由于word模板损失项图片都是三个一行，为了满足要求，每个list里面放三条数据
            List<LossItem> itemList = lossItemMapper.findByLoss(loss.getLossId());
            loss.setLossItems(itemList);

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
        dataMap.put("report",report);
        dataMap.put("lossList", lossList);
        //获取模板
        WordTemplate template=wordTemplateMapper.selectByPrimaryKey(report.getWordTemplateId());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String path=webPath+"upload/webapp/"+report.getProjectId()+"/报告-"+reportId+"-"+format.format(new Date());

        return WordUtils.createWord(template.getName(), path, dataMap, param);
    }

    /**
     * 拼装替换图片信息
     * @param webPath
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
                WordUtils.inputStream2ByteArray(new FileInputStream(webPath+"/webapp/upload"+image.getImage()), true));

        return header;
    }
}
