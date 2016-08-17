package com.ht.klinsurance.project.action;

import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.ht.HtMap;
import com.ht.common.http.DataBean;
import com.ht.common.http.HtRequest;
import com.ht.klinsurance.text.model.TextTemplate;
import junit.framework.TestCase;

import java.util.List;
import java.util.Map;

public class ProjectSyncLogActionTest extends TestCase {

    public void testGetCanSyncMessage() throws Exception {
        HtMap parameter = new HtMap();
        parameter.put("userId", "1");
        DataBean<JsonObject> dataBean = HtRequest.post("http://192.168.0.67:8080/klinsurance-service/projectSyncLogAction/getCanSyncMessage", parameter, JsonObject.class);
        Map a =  HtGson.fromJson(dataBean.getData().toString(), new TypeToken<Map>() {
        });
        List<TextTemplate> textTemplateList = (List<TextTemplate>) a.get("textTemplateList");
        System.out.println(dataBean.getData());
    }
}