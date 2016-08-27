package com.ht.klinsurance.common;

import com.ht.common.ht.HtProperties;

public class KlConsts {

    //项目标识文件夹
    public static final String BASE_DIR = "klinsurance-app";
    //ftp图片目录
    public static final String BASE_DIR_PIC = "pic";
    //ftp语音目录
    public static final String BASE_DIR_WORD = "word";
    //生成word时图片高度
    public static final Integer WORD_IMAGE_HEIGHT = 180;
    //生成word时图片宽度
    public static final Integer WORD_IMAGE_WIDTH = 220;
    /*********************发送邮件相关参数*********************************/
    //发送邮件的邮箱
    public static final String EMAIL_SEND_EMAIL;
    //发送邮件的邮箱密码
    public static final String EMAIL_SEND_PWD;
    //发送邮件的smtp服务器
    public static final String EMAIL_SMTP;
    /**********************end********************************/

    //分页数量
    public static final Integer PAGE_LIMIT = 10;
    public static  final String  IMG_SERVICE ;

    public static  final String  KLIN_BASE_URL ;
    public static  final String  COMMPSW ;
    static {
        HtProperties.load("/config.properties");

        KLIN_BASE_URL = HtProperties.get("klinsur.http");
        COMMPSW= HtProperties.get("klinsur.commPsw");
        IMG_SERVICE= HtProperties.get("ip.img_service");

        EMAIL_SEND_EMAIL= HtProperties.get("email.send_email");
        EMAIL_SEND_PWD= HtProperties.get("email.send_pwd");
        EMAIL_SMTP= HtProperties.get("email.smtp_serve");
    }
}
