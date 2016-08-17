package com.ht.klinsurance.textTemplate.action;

import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.ht.HtMap;
import com.ht.common.http.HtRequest;
import com.ht.common.utils.UUIDGenerate;
import com.ht.klinsurance.text.model.TextTemplate;
import junit.framework.TestCase;

import java.util.Date;

public class TextTemplateActionTest extends TestCase {

    public void testAddTextTemplate() throws Exception {
        TextTemplate textTemplate = new TextTemplate();

        textTemplate.setContent("aa");
        textTemplate.setCreateTime(new Date());
        textTemplate.setName("aaa");
        textTemplate.setTags("sss");
        textTemplate.setTextTemplateId(UUIDGenerate.generate());
        HtMap parameter = new HtMap();
        parameter.put("textTemplateJson", HtGson.toJson(textTemplate, new TypeToken<TextTemplate>() {
        }));
        String dataBean = HtRequest.post("http://192.168.0.67:8080/klinsurance-service/textTemplateAction/addTextTemplate", parameter);
        System.out.println(dataBean);
    }
}