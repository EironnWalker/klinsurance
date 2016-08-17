package com.ht.klinsurance.common;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class BaseAction {

    protected Logger log = Logger.getLogger(getClass());

    /**
     * 使用KEY获取Session中的值
     *
     * @param request
     * @param key
     * @return
     */
    public String getSessionValue(HttpServletRequest request, String key) {
        Object object = request.getSession().getAttribute(key);
        if (object != null) {
            return object.toString();
        }
        return null;
    }

}
