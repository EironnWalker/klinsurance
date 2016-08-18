package com.ht.klinsurance.common;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author feicy
 * @date 2016/8/18
 */
public class HttpImageUtils {
    /**
     * 获取ftp图片文件流
     * @param path
     * @return
     * @throws Exception
     */
    public static InputStream getFtpFileIs(String path) throws Exception{
        return HttpImageUtils.getFileInputStream(KlConsts.IMG_SERVICE+"/klinsurance-app"+path);
    }
    /**
     * 获取远程图片文件流
     * @param url
     * @return
     * @throws Exception
     */
    public static InputStream getFileInputStream(String url) throws Exception{
        URL picUrl;
        HttpURLConnection conn = null;
        InputStream is = null;
        picUrl = new URL(url);
        conn = (HttpURLConnection) picUrl.openConnection();
        conn.setConnectTimeout(20000);
        conn.setReadTimeout(20000);
        conn.connect();
        is = conn.getInputStream();
        return is;
    }
}
