package com.ht.klinsurance.customer.action;

import com.ht.common.ht.HtMap;
import com.ht.common.http.HtRequest;
import junit.framework.TestCase;

public class CustomerActionTest extends TestCase {

    public void testAddCustomer() throws Exception {
        //for(int i =0; i<3000;i++)
        //{
        //    Customer customer = new Customer();
        //    customer.setName("liu" + i);
        //    customer.setCreateTime(new Date());
        //    customer.setAddress("aa");
        //    customer.setLinkMan("liu" + i);
        //    customer.setLinkManPinyin("l");
        //    customer.setLinkPhone("1212");
        //    customer.setCustomerId(UUIDGenerate.generate());
        //    HtMap parameter = new HtMap();
        //
        //    parameter.put("customerJson", HtGson.toJson(customer, new TypeToken<Customer>() {
        //    }));
        //    String dataBean = HtRequest.post("http://192.168.0.67:8888/klinsurance-service/customerAction/addCustomer", parameter);
        //    System.out.println(dataBean);
        //}
            HtMap parameter = new HtMap();

            parameter.put("customerJson", "1");
            String dataBean = HtRequest.post("http://192.168.0.67:8080/klinsurance-service/customerAction/addCustomer", parameter);
            System.out.println(dataBean);
    }


}