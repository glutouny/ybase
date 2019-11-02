package com.yl.test;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yl.beans.SapItItems;
import com.yl.beans.SapItems;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/9/5  10:49
 */
public class TestSwitch {

    private static ObjectMapper mapper = new ObjectMapper();


    public static void main(String[] args) {
//        String fileName = null;
//        String fileCode = null;
//        String jobType = "Initial";
//        switch (jobType){
//            case "Initial":
//                fileCode = "1";
//                break;
//            case "Urgency":
//                fileCode = "2";
//                break;
//            case "Daily":
//                fileCode = "3";
//                break;
//            case "Urgent":
//                fileCode = "4";
//                break;
//            default:
//                break;
//        }
//        System.out.println(fileCode);
//        testCollection();
//        SapItems sapItems = new SapItems();
//        SapItItems sapItItems = initSapItItems(sapItems);
//        System.out.println(sapItems.getVorg()+"========"+sapItItems.getCode());
        if(1!=0){
            System.out.println("2345");
        }

        String string = "NULL";
        if(StringUtils.isNotEmpty(string)){
            System.out.println("0000000000000000");
        }

        String str = "0.03";
        System.out.println((long)(Double.valueOf(str)*100));


        String splitName = "HT113SLSPCS.20190924.20190920173715116";
        String name[] = splitName.split("\\.");
        System.out.println(name[0]);

        String str1 = "{\"123456\": 1,\"qwerty\": 2}";
//        Map<String,Integer> refundSkuPluInfoMap = JSON.parseObject(str1,Map.class);
//        for (Map.Entry<String,Integer> entry: refundSkuPluInfoMap.entrySet()) {
//            System.out.println(entry.getKey()+"========"+entry.getValue());
//        }
        try {
            Map<String,Integer> refundSkuPluInfoMap = deserializeToJsonByObjectMapper(str1,Map.class);
            for (Map.Entry<String,Integer> entry: refundSkuPluInfoMap.entrySet()) {
                System.out.println(entry.getKey()+"========"+entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 转换yyyyMMdd类型时间字符串
     * @param str
     * @return
     */
    public static Date transformToDate(final String str) {
        if (StringUtils.isNotBlank(str)) {
            final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
            try {
                return simpleDateFormat.parse(str);
            } catch (final Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            return null;
        }
    }

    public static void testCollection(){
        List<SapItItems> sapItItems = new ArrayList<>();
        SapItItems s1 = new SapItItems();
        s1.setDateTime(new Date());
        s1.setCreationTime(transformToDate("20190909"));
        s1.setCode("S1");
        sapItItems.add(s1);
        SapItItems s2 = new SapItItems();
        s2.setDateTime(transformToDate("20190909"));
        s2.setCreationTime(new Date());
        s2.setCode("S2");
        sapItItems.add(s2);

        SapItItems s3 = new SapItItems();
        s3.setDateTime(new Date());
        s3.setCreationTime(new Date());
        s3.setCode("S3");
        sapItItems.add(s3);
        List<SapItItems>  s = sapItItems.stream().sorted(Comparator.comparing(SapItItems::getDateTime).thenComparing(SapItItems::getCreationTime).reversed()).collect(Collectors.toList());
        if(CollectionUtils.isNotEmpty(s)){
            s.remove(0);
            System.out.println(s.size());
        }
        System.out.println("12345678");
        s.stream().forEach(sapItItems1 -> {
            System.out.println(sapItItems1.getDateTime()+"==="+sapItItems1.getCode()+"==="+sapItItems1.getCreationTime());
        });

        String erroMsg = String.format("%s 平台类型为盒马，退款类型为%s,退款阶段为%s,不符合转异常条件%s", "123456",
                "1", "2", "20190992");
        System.out.println("errorMsg"+erroMsg);
    }

    public static  SapItItems initSapItItems(SapItems sapItems){
        SapItItems sapItItems = new SapItItems();
        sapItItems.setCode("1234567");
        sapItems.setVorg("haaaaa");
        return sapItItems;
    }

    /**
     * @description: 将Json String反序列化成Object
     * @author: lijuan.li
     * @date: 2016/12/13 10:00
     */
    public static <T> T deserializeToJsonByObjectMapper(final String message, final Class<T> classType) throws IOException {
        if (message == null) {
            return null;
        }
        return mapper.readValue(message, classType);
    }
}
