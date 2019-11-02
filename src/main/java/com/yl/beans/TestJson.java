package com.yl.beans;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/10/15  16:04
 */
public class TestJson {

    public static void main(String[] args) {
        String s = "{\n" +
                "\t\"status\": \"ENTER_WAREHOUSE_SUCCESS\",\n" +
                "\t\"fulfill\": \"{\\\"events\\\":[{\\\"bizOrderId\\\":\\\"121581010819101608\\\",\\\"channelStockRelated\\\":false,\\\"combo\\\":false,\\\"ext\\\":{\\\"pluCode\\\":\\\"{\\\\\\\"2000109011615\\\\\\\":1,\\\\\\\"2000117883464\\\\\\\":1}\\\",\\\"fulfillBatchId\\\":\\\"442372017919101605\\\"},\\\"fulfillOrderId\\\":\\\"143559019019101608\\\",\\\"fulfillSubOrderId\\\":\\\"246384000319101608\\\",\\\"gmtModified\\\":1571219574279,\\\"lightRefund\\\":false,\\\"paramsMap\\\":{\\\"actionIndex\\\":0,\\\"properties\\\":{}},\\\"standardSku\\\":false,\\\"subBizOrderId\\\":\\\"221398018719101608\\\",\\\"subSourceOrderId\\\":\\\"665834688265823853\\\",\\\"warehouseCode\\\":\\\"SUPYYKTEST\\\"}],\\\"paramsMap\\\":{\\\"actionIndex\\\":0,\\\"properties\\\":{}}}\",\n" +
                "\t\"msg_id\": \"e95b4f25-182c-4e30-aea7-1d4087dc4c75\"\n" +
                "}";
        FrpfHemPluFulfillPojo pojo = JSONObject.parseObject(s,FrpfHemPluFulfillPojo.class);
        System.out.println(pojo.getFulfill());
        FrpfHemPluFlufillInfoPojo pojo1 = JSONObject.parseObject(pojo.getFulfill(),FrpfHemPluFlufillInfoPojo.class);
        System.out.println(JSONObject.toJSONString(pojo1));
//        for (FrpfHemPluFulfillEventPojo eventPojo:pojo1.getEvents()) {
//            Map<String,String> ext = eventPojo.getExt();
//            final String pluCodes = ext.get("pluCode");
//            Map<String, Integer> skuPluInfoMap = JSON.parseObject(pluCodes, Map.class);
//            for (final Map.Entry<String, Integer> entry :skuPluInfoMap.entrySet()) {
//                System.out.println(entry.getKey()+"================"+entry.getValue());
//            }
//        }
        System.out.println(pojo1.getEvents().get(0).getBizOrderId());
//        FrpfHemPluFulfillPojo1 pojo = JSONObject.parseObject(s,FrpfHemPluFulfillPojo1.class);
    }
}
