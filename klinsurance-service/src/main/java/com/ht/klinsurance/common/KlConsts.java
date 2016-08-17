package com.ht.klinsurance.common;

import com.ht.common.ht.HtProperties;

public class KlConsts {

    //项目标识文件夹
    public static final String BASE_DIR = "klinsurance-app";
    //ftp图片目录
    public static final String BASE_DIR_PIC = "pic";
    //ftp语音目录
    public static final String BASE_DIR_VOICE = "voice";
    //生成word时图片高度
    public static final Integer WORD_IMAGE_HEIGHT = 180;
    //生成word时图片宽度
    public static final Integer WORD_IMAGE_WIDTH = 220;

    public static  final String  KLIN_BASE_URL ;
    public static  final String  COMMPSW ;
    static {
        HtProperties.load("/config.properties");

        KLIN_BASE_URL = HtProperties.get("klinsur.http");
        COMMPSW= HtProperties.get("klinsur.commPsw");
    }
}
