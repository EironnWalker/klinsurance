package com.ht.klinsurance.common;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author wuxl
 * @date 2015/12/7
 */
@Data
public class UploadDemoVo {

    /**
     * 文件
     */
    private MultipartFile[] imgFiles;

    private MultipartFile ftpVoice;

    private MultipartFile ftpVideo;



    public boolean validateFile() throws Exception{
        /*if(!ConstantUtil.fileTypeImg.contains(this.getImgFile().getContentType())){
            throw new Exception("文件类型只能是jpeg、png！");
        }
        if(this.getImgFile().getSize() > 1000 * 100){
            throw new Exception("文件最大不能超过100KB！");
        }*/
        return true;
    }

}
