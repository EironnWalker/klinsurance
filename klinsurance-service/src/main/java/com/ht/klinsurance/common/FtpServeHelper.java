package com.ht.klinsurance.common;

import com.ht.common.ht.HtProperties;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FtpServeHelper {
    public static final String LOCATION; // 地址
    public static final Integer PORT; // 端口
    public static final String USERNAME; // 用户名
    public static final String PASSWORD; // 密码
    public static final String DEFAULT_WORKING_DIRECTORY; // 默认目录

    static {
        HtProperties.load("/config.properties");

        LOCATION = HtProperties.get("ftp.location");
        PORT = Integer.parseInt(HtProperties.get("ftp.port"));
        USERNAME = HtProperties.get("ftp.username");
        PASSWORD = HtProperties.get("ftp.password");
        DEFAULT_WORKING_DIRECTORY = HtProperties.get("ftp.defaultWorkingDirectory");

        if (StringUtils.isBlank(LOCATION)) {
            throw new RuntimeException("ftp is Undefined.");
        }
    }

    /**
     * 获取FTP连接
     *
     * @return
     * @author lindapeng
     */
    public static FTPClient getConnection() {
        FTPClient ftp = new FTPClient();
        try {
            ftp.connect(LOCATION, PORT);
            ftp.login(USERNAME, PASSWORD);
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE); // 文件类型为二进制文件
            int reply = ftp.getReplyCode(); // 获取答复编号
            if (!FTPReply.isPositiveCompletion(reply)) { // 如果不成功
                ftp.disconnect();
                return null;
            }
            ftp.changeWorkingDirectory(DEFAULT_WORKING_DIRECTORY);
            return ftp;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 获取ftp文件流
     * @param fileName
     * @return
     * @throws Exception
     */
    public static InputStream getFileInputStream(String fileName) throws Exception{
        String filepath = "ftp://" + USERNAME + ":" + PASSWORD + "@"
                + LOCATION + DEFAULT_WORKING_DIRECTORY  + fileName;
        URL url = new URL(filepath);
        URLConnection urlconn = url.openConnection();
        InputStream in = urlconn.getInputStream();
        return in;
    }
}
