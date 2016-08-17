package com.ht.klinsurance.common;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public  class HttpGetHelper {

    private static CloseableHttpClient httpClient;
    private static final String CHARSET = "UTF-8";
    private static final int TIMEOUT = 30000;
    private static final int SOCKETTIMEOUT = 120000;

    static {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(TIMEOUT).setSocketTimeout(SOCKETTIMEOUT).build();
        httpClient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
    }

    /**
 * 发送Get请求
 *
 * @param url       请求地址
 * @param parameter 请求参数
 * @return
 */
public static String doGet(String url, Map<String, Object> parameter) {
    if (StringUtils.isBlank(url)) {
        return null;
    }
    try {
        if (parameter != null && !parameter.isEmpty()) {
            List<NameValuePair> pairs = new ArrayList<NameValuePair>(parameter.size());
            for (Map.Entry<String, Object> entry : parameter.entrySet()) {
                String value = entry.getValue().toString();
                if (value != null) {
                    pairs.add(new BasicNameValuePair(entry.getKey(), value));
                }
            }
            url += "?" + EntityUtils.toString(new UrlEncodedFormEntity(pairs, CHARSET));
        }
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            httpGet.abort();
            throw new RuntimeException("HttpClient,error status code :" + statusCode);
        }
        HttpEntity entity = response.getEntity();
        String result = null;
        if (entity != null) {
            result = EntityUtils.toString(entity, "UTF-8");
        }
        EntityUtils.consume(entity);
        response.close();
        return result;
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}


}
