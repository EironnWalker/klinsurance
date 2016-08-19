package com.ht.klinsurance.word;

import com.ht.klinsurance.common.FtpServeHelper;
import com.ht.klinsurance.common.WordUtils;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * freemarker根据模板生成word
 * @author feicy
 * @date 2016/7/4
 */
public class Test {

    public static void main(String args[])throws Exception{
        /** 用于组装word页面需要的数据 */
        Map<String, Object> dataMap = new HashMap<String, Object>();

        /** 组装数据 */
         SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        dataMap.put("currentDate", sdf.format(new Date()));
        dataMap.put("location", "中国石油天然气股份有限公司浙江销售分公司宁波市");
        dataMap.put("insuranceInfo", "中国石油天然气股份有限公司浙江销售分公司");
        dataMap.put("linkInfo", "孙敏佳：18611806277；sunminjia@kunlunrisk.com");
        dataMap.put("accidentDesc", "2015年7月11日傍晚，台风“灿鸿”从浙江舟山朱家尖登陆，中心附近最大风力有14级，台风伴随强降雨等自然灾害，造成浙江销售嘉兴地区、绍兴地区、宁波地区、湖州地区、舟山地区、温州地区、台州地区所属的加油站等资产受到不同程度损失。");
        dataMap.put("image1", "bd04cc2d2c5b11e6bd17000c299447f9");
        dataMap.put("image2", "d6a20d183edb11e6959400163e000231");
        dataMap.put("image3", "f983631e573711e6afad00163e000231");

        List<Map<String, Object>> userList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("info1", "孙敏佳1");
        map.put("info2", "苏群1");
        map.put("info3", "37fb7787d0354d42be01328b2e19d065");
        userList.add(map);

        map = new HashMap<String, Object>();
        map.put("info1", "孙敏佳2");
        map.put("info2", "苏群2");
        map.put("info3", "26e9216a6c8c4a2bb645e990df067e06");
        userList.add(map);

        map = new HashMap<String, Object>();
        map.put("info1", "孙敏佳3");
        map.put("info2", "苏群2");
        map.put("info3", "703bd696d52047cfbc086523ce401c41");
        userList.add(map);

        dataMap.put("infoList", userList);
        //图片信息
        Map<String, Object> param = new HashMap<String, Object>();

        FtpServeHelper.getConnection();

       Map<String,Object> header = new HashMap<String, Object>();
        header.put("width", 220);
        header.put("height", 180);
        header.put("type", "png");
        header.put("content",
                WordUtils.inputStream2ByteArray(new FileInputStream("d:/图片1.jpg"), true));
        param.put("bd04cc2d2c5b11e6bd17000c299447f9", header);

        header = new HashMap<String, Object>();
        header.put("width", 220);
        header.put("height", 180);
        header.put("type", "png");
        header.put("content", WordUtils.inputStream2ByteArray(new FileInputStream("d:/图片1.jpg"), true));
        param.put("d6a20d183edb11e6959400163e000231", header);

        header = new HashMap<String, Object>();
        header.put("width", 220);
        header.put("height", 180);
        header.put("type", "png");
        header.put("content", WordUtils.inputStream2ByteArray(new FileInputStream("d:/图片1.jpg"), true));
        param.put("f983631e573711e6afad00163e000231", header);

        WordUtils.createWord("简报.ftl", "d:/简报1.docx", dataMap, dataMap);
    }
}
