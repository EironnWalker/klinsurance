package com.ht.klinsurance.user.action;

import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.ht.HtMap;
import com.ht.common.http.HtRequest;
import com.ht.klinsurance.user.model.User;
import junit.framework.TestCase;

public class UserActionTest extends TestCase {

    public void testLogin() throws Exception {

        User user = new User();
        user.setLoginName("luochenggang");
        user.setLoginPwd("Lcgzyh01");
        //user.setLoginPwd("12345");
        HtMap parameter = new HtMap();
        parameter.put("userJson", HtGson.toJson(user, new TypeToken<User>() {
        }));
        String dataBean = HtRequest.post("http://192.168.0.67:8080/klinsurance-service/userAction/login", parameter);
        System.out.println(dataBean);
    }
}