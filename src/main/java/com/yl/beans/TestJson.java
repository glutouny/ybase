package com.yl.beans;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yl.util.JacksonUtil;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/10/15  16:04
 */
public class TestJson {

    public static final ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        String s = "{\n" +
                "\t\"status\": \"ENTER_WAREHOUSE_SUCCESS\",\n" +
                "\t\"fulfill\": \"{\\\"events\\\":[{\\\"bizOrderId\\\":\\\"121581010819101608\\\",\\\"channelStockRelated\\\":false,\\\"combo\\\":false,\\\"ext\\\":{\\\"pluCode\\\":\\\"{\\\\\\\"2000109011615\\\\\\\":1,\\\\\\\"2000117883464\\\\\\\":1}\\\",\\\"fulfillBatchId\\\":\\\"442372017919101605\\\"},\\\"fulfillOrderId\\\":\\\"143559019019101608\\\",\\\"fulfillSubOrderId\\\":\\\"246384000319101608\\\",\\\"gmtModified\\\":1571219574279,\\\"lightRefund\\\":false,\\\"paramsMap\\\":{\\\"actionIndex\\\":0,\\\"properties\\\":{}},\\\"standardSku\\\":false,\\\"subBizOrderId\\\":\\\"221398018719101608\\\",\\\"subSourceOrderId\\\":\\\"665834688265823853\\\",\\\"warehouseCode\\\":\\\"SUPYYKTEST\\\"}],\\\"paramsMap\\\":{\\\"actionIndex\\\":0,\\\"properties\\\":{}}}\",\n" +
                "\t\"msg_id\": \"e95b4f25-182c-4e30-aea7-1d4087dc4c75\"\n" +
                "}";
//        FrpfHemPluFulfillPojo pojo = JSONObject.parseObject(s,FrpfHemPluFulfillPojo.class);
//        System.out.println(pojo.getFulfill());
//        FrpfHemPluFlufillInfoPojo pojo1 = JSONObject.parseObject(pojo.getFulfill(),FrpfHemPluFlufillInfoPojo.class);
//        System.out.println(JSONObject.toJSONString(pojo1));
//        for (FrpfHemPluFulfillEventPojo eventPojo:pojo1.getEvents()) {
//            Map<String,String> ext = eventPojo.getExt();
//            final String pluCodes = ext.get("pluCode");
//            Map<String, Integer> skuPluInfoMap = JSON.parseObject(pluCodes, Map.class);
//            for (final Map.Entry<String, Integer> entry :skuPluInfoMap.entrySet()) {
//                System.out.println(entry.getKey()+"================"+entry.getValue());
//            }
//        }
//        System.out.println(pojo1.getEvents().get(0).getBizOrderId());
//        FrpfHemPluFulfillPojo1 pojo = JSONObject.parseObject(s,FrpfHemPluFulfillPojo1.class);


//        testHemOrder();

        testPromotionINfo();
    }

    public static  void testHemOrder(){
        String hemOrder = "{\"store_id\":\"SUPYYKTEST\",\"merchant_code\":\"supplier_500000002011895\",\"sub_orders\":[{\"share_discount_amt\":0,\"item_code\":\"40869408003000\",\"sale_unit\":\"件\",\"order_status\":\"SHIPPED\",\"buy_amount_stock\":2.0,\"status_change_time\":{\"PACKAGED\":\"2019-11-19 16:26:40\",\"latestArriveTime\":\"2019-11-19 17:00:00\",\"SHIPPING\":\"2019-11-19 16:31:06\",\"SHIPPED\":\"2019-11-19 16:31:07\"},\"ns_quantity\":0.0,\"pick_amount_stock\":2.0,\"price\":100,\"trd_type\":1,\"pick_amt\":150,\"biz_order_id\":5000161442066460433,\"order_type\":\"COMMON\",\"promotion_discount_amt\":50,\"store_id\":\"SUPYYKTEST\",\"quantity\":2,\"auction_id\":607212334625,\"original_amt\":200,\"trade_sub_attributes\":{\"tpSubOrderStatus\":\"SUCCESS\",\"isStandardItem\":\"1\"},\"member_discount_amt\":0,\"tb_biz_order_id\":722314274904394286,\"parent_id\":5000161442066450433,\"promotion_info\":\"[{\\\"activeId\\\":\\\"1190010972020191113203204870\\\",\\\"activeName\\\":\\\"满2件减0.5元\\\",\\\"discountFee\\\":50,\\\"outActiveId\\\":\\\"1190010972020191113203204870\\\",\\\"txdActiveId\\\":\\\"10148248952\\\",\\\"type\\\":\\\"wdkShopMJ\\\"}]\",\"sku_code\":\"40869408003000\",\"stock_unit\":\"件\"},{\"share_discount_amt\":0,\"item_code\":\"41774200120001\",\"sale_unit\":\"件\",\"order_status\":\"SHIPPED\",\"buy_amount_stock\":1.0,\"status_change_time\":{\"PACKAGED\":\"2019-11-19 16:26:40\",\"latestArriveTime\":\"2019-11-19 17:00:00\",\"SHIPPING\":\"2019-11-19 16:31:06\",\"SHIPPED\":\"2019-11-19 16:31:07\"},\"ns_quantity\":0.0,\"pick_amount_stock\":1.0,\"price\":100,\"trd_type\":1,\"pick_amt\":100,\"biz_order_id\":5000161442066470433,\"order_type\":\"COMMON\",\"promotion_discount_amt\":0,\"store_id\":\"SUPYYKTEST\",\"quantity\":1,\"auction_id\":606731304148,\"original_amt\":100,\"trade_sub_attributes\":{\"tpSubOrderStatus\":\"SUCCESS\",\"isStandardItem\":\"1\"},\"member_discount_amt\":0,\"tb_biz_order_id\":722314274905394286,\"parent_id\":5000161442066450433,\"promotion_info\":\"[]\",\"sku_code\":\"41774200120001\",\"stock_unit\":\"件\"}],\"post_fee\":0,\"original_amt\":300,\"order_client\":\"app\",\"open_uid\":\"AAH82s2vAJW4VAbDglXAkY85\",\"discount_amt\":50,\"pay_time\":\"2019-11-19 16:11:10\",\"shop_id\":\"235729002\",\"order_status\":\"SUCCESS\",\"member_discount_amt\":0,\"tb_biz_order_id\":722314274903394286,\"order_from\":4,\"trd_type\":1,\"pay_channels\":[{\"store_id\":\"SUPYYKTEST\",\"pay_amount\":250,\"trd_type\":1,\"pay_type\":6,\"order_channel\":\"APP|淘宝\",\"biz_order_id\":5000161442066450433,\"refund_quantity\":0.0}],\"package_time\":\"2019-11-19 16:26:40\",\"trade_attributes\":{\"arriveType\":\"2\",\"expectArriveTime\":\"2019-11-19 16:30:00~2019-11-19 17:00:00\",\"batchId\":\"425151040819111906\",\"scenarioGroup\":\"HM\",\"batchTime\":\"2019-11-19 16:27:06\",\"topMsgRepeatTag\":\"1\",\"financeOrganizationName\":\"铭书测试聂隗的公司\",\"orderClient\":\"2\",\"successTime\":\"2019-11-19 16:31:07\",\"storeName\":\"优衣库预发测试商家公司\",\"financeOrganizationCode\":\"FIN_supplier_100054162\",\"packagedStatus\":\"PACKAGED\",\"fulfillBizOrderId\":\"124784779119111948\"},\"biz_order_id\":5000161442066450433}";
        FrpfHemOrderPojo hemOrderPojo = JSONObject.parseObject(hemOrder,FrpfHemOrderPojo.class);
        System.out.println(hemOrderPojo.getTbBizOrderId()+"----"+hemOrderPojo.getOrderStatus());
    }

    public static void testPromotionINfo() throws IOException {
        String hemOrder = "{\"store_id\":\"SUPYYKTEST\",\"merchant_code\":\"supplier_500000002011895\",\"sub_orders\":[{\"share_discount_amt\":0,\"item_code\":\"40869408003000\",\"sale_unit\":\"件\",\"order_status\":\"SHIPPED\",\"buy_amount_stock\":2.0,\"status_change_time\":{\"PACKAGED\":\"2019-11-19 16:26:40\",\"latestArriveTime\":\"2019-11-19 17:00:00\",\"SHIPPING\":\"2019-11-19 16:31:06\",\"SHIPPED\":\"2019-11-19 16:31:07\"},\"ns_quantity\":0.0,\"pick_amount_stock\":2.0,\"price\":100,\"trd_type\":1,\"pick_amt\":150,\"biz_order_id\":5000161442066460433,\"order_type\":\"COMMON\",\"promotion_discount_amt\":50,\"store_id\":\"SUPYYKTEST\",\"quantity\":2,\"auction_id\":607212334625,\"original_amt\":200,\"trade_sub_attributes\":{\"tpSubOrderStatus\":\"SUCCESS\",\"isStandardItem\":\"1\"},\"member_discount_amt\":0,\"tb_biz_order_id\":722314274904394286,\"parent_id\":5000161442066450433,\"promotion_info\":\"[{\\\"activeId\\\":\\\"1190010972020191113203204870\\\",\\\"activeName\\\":\\\"满2件减0.5元\\\",\\\"discountFee\\\":50,\\\"outActiveId\\\":\\\"1190010972020191113203204870\\\",\\\"txdActiveId\\\":\\\"10148248952\\\",\\\"type\\\":\\\"wdkShopMJ\\\"}]\",\"sku_code\":\"40869408003000\",\"stock_unit\":\"件\"},{\"share_discount_amt\":0,\"item_code\":\"41774200120001\",\"sale_unit\":\"件\",\"order_status\":\"SHIPPED\",\"buy_amount_stock\":1.0,\"status_change_time\":{\"PACKAGED\":\"2019-11-19 16:26:40\",\"latestArriveTime\":\"2019-11-19 17:00:00\",\"SHIPPING\":\"2019-11-19 16:31:06\",\"SHIPPED\":\"2019-11-19 16:31:07\"},\"ns_quantity\":0.0,\"pick_amount_stock\":1.0,\"price\":100,\"trd_type\":1,\"pick_amt\":100,\"biz_order_id\":5000161442066470433,\"order_type\":\"COMMON\",\"promotion_discount_amt\":0,\"store_id\":\"SUPYYKTEST\",\"quantity\":1,\"auction_id\":606731304148,\"original_amt\":100,\"trade_sub_attributes\":{\"tpSubOrderStatus\":\"SUCCESS\",\"isStandardItem\":\"1\"},\"member_discount_amt\":0,\"tb_biz_order_id\":722314274905394286,\"parent_id\":5000161442066450433,\"promotion_info\":\"[]\",\"sku_code\":\"41774200120001\",\"stock_unit\":\"件\"}],\"post_fee\":0,\"original_amt\":300,\"order_client\":\"app\",\"open_uid\":\"AAH82s2vAJW4VAbDglXAkY85\",\"discount_amt\":50,\"pay_time\":\"2019-11-19 16:11:10\",\"shop_id\":\"235729002\",\"order_status\":\"SUCCESS\",\"member_discount_amt\":0,\"tb_biz_order_id\":722314274903394286,\"order_from\":4,\"trd_type\":1,\"pay_channels\":[{\"store_id\":\"SUPYYKTEST\",\"pay_amount\":250,\"trd_type\":1,\"pay_type\":6,\"order_channel\":\"APP|淘宝\",\"biz_order_id\":5000161442066450433,\"refund_quantity\":0.0}],\"package_time\":\"2019-11-19 16:26:40\",\"trade_attributes\":{\"arriveType\":\"2\",\"expectArriveTime\":\"2019-11-19 16:30:00~2019-11-19 17:00:00\",\"batchId\":\"425151040819111906\",\"scenarioGroup\":\"HM\",\"batchTime\":\"2019-11-19 16:27:06\",\"topMsgRepeatTag\":\"1\",\"financeOrganizationName\":\"铭书测试聂隗的公司\",\"orderClient\":\"2\",\"successTime\":\"2019-11-19 16:31:07\",\"storeName\":\"优衣库预发测试商家公司\",\"financeOrganizationCode\":\"FIN_supplier_100054162\",\"packagedStatus\":\"PACKAGED\",\"fulfillBizOrderId\":\"124784779119111948\"},\"biz_order_id\":5000161442066450433}";
        FrpfHemOrderPojo hemOrderPojo = mapper.readValue(hemOrder,FrpfHemOrderPojo.class);
        System.out.println(hemOrderPojo.getSubOrders());
        String str = hemOrderPojo.getSubOrders().get().iterator().next().getPromotionInfo();
        System.out.println(str);
        List<FrpfHemPromotionInfo> promotionInfoList = JacksonUtil.readValue(str,List.class,FrpfHemPromotionInfo.class);
        System.out.println(JSONObject.toJSONString(promotionInfoList));
        for (FrpfHemOrderEntryPojo orderEntryPojo:hemOrderPojo.getSubOrders().get()) {
//            String promotionInfo = orderEntryPojo.getPromotionInfo();
//            System.out.println(promotionInfo);
////            FrpfHemPromotionInfoList list = mapper.readValue(promotionInfo,FrpfHemPromotionInfoList.class);
////            System.out.println(list.getPromotionInfo().get(0).getActiveId());
//            JSONArray jsonArray = JSON.parseArray(promotionInfo);
//            for (Object object:jsonArray) {
//                JSONObject jsonObject = (JSONObject) object;
//                System.out.println(jsonObject.get("type"));
//                System.out.println(jsonObject.get("discountFee"));
//            }
        }

    }
}
