package com.ht.klinsurance.loss.action;

import com.google.gson.reflect.TypeToken;
import com.ht.common.gson.HtGson;
import com.ht.common.ht.HtMap;
import com.ht.common.http.HtRequest;
import com.ht.common.utils.UUIDGenerate;
import com.ht.klinsurance.loss.model.Loss;
import com.ht.klinsurance.loss.model.LossItem;
import junit.framework.TestCase;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LossActionTest extends TestCase {

    public void testAddLoss() throws Exception {
        Loss loss = new Loss();
        loss.setCreateTime(new Date());
        loss.setCustomerSignPath("siginPath");
        loss.setProjectId("1");
        loss.setCustomerSignTime(new Date());
        loss.setLossId(UUIDGenerate.generate());
        loss.setPlace("aa");
        loss.setRemark("aa");
        loss.setUserId("1");
        List<LossItem> itemList = new ArrayList<LossItem>();
        LossItem item = new LossItem();
        item.setRemark("aa");
        item.setLossId(loss.getLossId());
        item.setCreateTime(new Date());
        item.setHeight(new BigDecimal("1"));
        item.setLength(new BigDecimal("2"));
        item.setLossItemId("11");
        item.setLossItemName("222");
        item.setPrice(new BigDecimal("3"));
        item.setLossNumber(4);
        item.setProjectId("1");
        item.setRealLossAmount(new BigDecimal("2"));
        item.setReportedLossAmount(new BigDecimal("4"));
        item.setWidth(new BigDecimal("5"));
        itemList.add(item);
        HtMap parameter = new HtMap();
        parameter.put("lossJson", HtGson.toJson(loss, new TypeToken<Loss>() {
        }));
        parameter.put("lossItemJson", HtGson.toJson(itemList, new TypeToken<List<LossItem>>() {
        }));
        String dataBean = HtRequest.post("http://192.168.0.67:8080/klinsurance-service/lossAction/addLoss", parameter);
        System.out.println(dataBean);
    }
}