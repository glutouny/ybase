package com.yl.test;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.javafx.binding.StringFormatter;
import com.yl.beans.User;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangli
 * @title   TestJackSon
 * @description 测试一些jackson
 * @DATE 2019/7/25  14:04
 */
public class TestJackSon {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        //language=JSON
        String userString = "{\n" +
                "  \"username\" : \"goudan\",\n" +
                "  \"password\" : \"123456\" \n" +
                "}";
        try {
            User user = mapper.readValue(userString,User.class);
            System.out.println(user);

            String stringUser = mapper.writeValueAsString(user);
            System.out.println(stringUser);

            /*下面是alibaba-Json转换*/
            JSONObject jsonObject = JSONObject.parseObject(stringUser);
            System.out.println(jsonObject.get("username")+"-------------"+jsonObject.get("password"));

            User jsonUser = JSONObject.parseObject(stringUser,User.class);
            System.out.println("---jsonUser-----"+jsonUser);

            List<User> users = new ArrayList<>();
            if(CollectionUtils.isNotEmpty(users)){
                System.out.println("this is not empty List");
            }

            String usess = "  ";
            if(StringUtils.isAnyEmpty(usess)){
                System.out.println("----------------");
            }

            String msg = "你好啊%s";
            System.out.println(String.format(msg, "a"));

            String endPoint =  "s3.s3.cn-north-1.amazonaws.com.cn";
            String[] split = endPoint.split("\\.");
            String s = split[2];
            System.out.println(s);

            String changestr = "790100";
            String changeString = changestr.substring(0,changestr.length()-2);
            System.out.println("==="+appendDotAndConvertToDouble("0",2));

            String a = "11.11";
            Double ab = 11d;
            String sdf =  String.valueOf((long)(ab.doubleValue()*100));
            System.out.println(Long.valueOf(sdf));

            StringBuffer stringBuffer = new StringBuffer();
            System.out.println(stringBuffer.toString());

//            System.out.println((long)(ab.doubleValue()*100));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static  Double appendDotAndConvertToDouble(final String doubleStr, final int decimalPlace) {
        final int length = doubleStr.length();
        final StringBuilder splitDoubleStr = new StringBuilder(length + 1);
        splitDoubleStr.append(doubleStr.substring(0, length - decimalPlace)).append(".")
                .append(doubleStr.substring(length - decimalPlace, length));
        final BigDecimal bigDecimal = new BigDecimal(splitDoubleStr.toString());
        return bigDecimal.doubleValue();
    }
}
