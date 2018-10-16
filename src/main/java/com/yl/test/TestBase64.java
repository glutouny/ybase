package com.yl.test;

import com.yl.util.Base64Utils;

/**
 * @author 杨黎
 * @Title
 * @description
 * @DATE 2018/9/29  14:33
 */
public class TestBase64 {

    public static void main(String[] args) {
        String str = "userName";
        String password = String.valueOf(System.currentTimeMillis());
        String enpass = Base64Utils.encodeBase64(str+":"+password);
        System.out.println("加密后为:"+enpass);
        String depass = Base64Utils.decodeBase64(enpass);
        System.out.println("解密后为:"+depass);
    }
}
