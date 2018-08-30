package com.yl.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;

/**
 * @author 杨黎
 * @Title Base64Utils
 * @description Base64
 * @DATE 2018/8/30
 */
public class Base64Utils {

    private static String KEY="PWD_TRANSPORT";
    // 加密
    public static String encodeBase64(String str) {
        byte[] b = null;
        String s = null;
        try {
            b = (str+KEY).getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (b != null) {
            s = new BASE64Encoder().encode(b);
        }
        return s;
    }

    // 解密
    public static String decodeBase64(String s) {
        byte[] b = null;
        String result = null;
        if (s != null) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                b = decoder.decodeBuffer(s);
                result = new String(b, "utf-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result.replace(KEY, "");
    }

}
