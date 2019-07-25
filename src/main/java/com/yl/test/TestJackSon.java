package com.yl.test;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.yl.beans.User;

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
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
