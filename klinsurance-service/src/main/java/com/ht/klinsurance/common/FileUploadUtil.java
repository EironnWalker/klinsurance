package com.ht.klinsurance.common;

import com.ht.common.utils.DateUtils;
import com.ht.common.utils.UUIDGenerate;
import org.apache.commons.net.ftp.FTPClient;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

/**
 * @author wuxl
 * @date 2015/12/7
 */
public class FileUploadUtil {

    /**
     * 上传图片
     * @param picList
     */
    public static String uploadFilePic(List<String> picList)
    {
        try {
            String dateFolder = DateUtils.format(new Date(), "yyyyMMdd");
            BASE64Decoder decoder = new BASE64Decoder();
            StringBuffer strBuf = new StringBuffer();

            FTPClient ftp = FtpServeHelper.getConnection();
            String baseDir = KlConsts.BASE_DIR;
            String basePic = KlConsts.BASE_DIR_PIC;
            ftp.changeWorkingDirectory(FtpServeHelper.DEFAULT_WORKING_DIRECTORY);
            ftp.makeDirectory(baseDir);
            ftp.changeWorkingDirectory(ftp.printWorkingDirectory() + "/" + baseDir);
            ftp.makeDirectory(basePic);
            ftp.changeWorkingDirectory(ftp.printWorkingDirectory() + "/" + basePic);
            ftp.makeDirectory(dateFolder);
            ftp.changeWorkingDirectory(ftp.printWorkingDirectory() + "/" + dateFolder);
            for (int i = 0; i < picList.size(); i++) {
                byte[] byteFile = decoder.decodeBuffer(picList.get(i));
                String fileName = UUIDGenerate.generate()+".jpg";
                ftp.storeFile(fileName,  new ByteArrayInputStream(byteFile));
                strBuf.append("/").append(basePic).append("/").append(dateFolder).append("/").append(fileName);
                if(i< picList.size()-1)
                {
                    strBuf.append(",");
                }
            }
            ftp.disconnect();
            return strBuf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 上传图片
     * @param filePath
     * @param extendName
     */
    public static String uploadFileWord(List<String> filePath,String extendName)
    {
        try {
            String dateFolder = DateUtils.format(new Date(), "yyyyMMdd");
            BASE64Decoder decoder = new BASE64Decoder();
            StringBuffer strBuf = new StringBuffer();

            FTPClient ftp = FtpServeHelper.getConnection();
            String baseDir = KlConsts.BASE_DIR;
            String basePic = KlConsts.BASE_DIR_WORD;
            ftp.changeWorkingDirectory(FtpServeHelper.DEFAULT_WORKING_DIRECTORY);
            ftp.makeDirectory(baseDir);
            ftp.changeWorkingDirectory(ftp.printWorkingDirectory() + "/" + baseDir);
            ftp.makeDirectory(basePic);
            ftp.changeWorkingDirectory(ftp.printWorkingDirectory() + "/" + basePic);
            ftp.makeDirectory(dateFolder);
            ftp.changeWorkingDirectory(ftp.printWorkingDirectory() + "/" + dateFolder);
            for (int i = 0; i < filePath.size(); i++) {
                byte[] byteFile = decoder.decodeBuffer(filePath.get(i));
                String fileName = UUIDGenerate.generate()+"."+extendName;
                ftp.storeFile(fileName,  new ByteArrayInputStream(byteFile));
                strBuf.append("/").append(basePic).append("/").append(dateFolder).append("/").append(fileName);
                if(i< filePath.size()-1)
                {
                    strBuf.append(",");
                }
            }
            ftp.disconnect();
            return strBuf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }







}
