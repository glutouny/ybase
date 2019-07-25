package com.yl.beans;


import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/5/29  19:46
 */
public class TestSap {

    public static void main(String[] args) {
        SapIRoot sapIRoot = new SapIRoot();

        if(sapIRoot == null || "".equals(sapIRoot)){
            System.out.println("asdfghjk");
        }
        if(StringUtils.isBlank(sapIRoot.toString())){
            System.out.println("111234");
        }
        SapItHead sapItHead = new SapItHead();
        sapItHead.setHead("head");
        if(StringUtils.isNotBlank(sapItHead.toString())){
            System.out.println(sapItHead.toString());
        }
        sapIRoot.setI_HEAD(sapItHead);
        SapItItems[] sapItItems = new SapItItems[2];
        sapIRoot.setIitems(sapItItems);
        for(int i = 0; i < 2;i++){
            SapItItems sapItItems1 = new SapItItems();
            SapItems sapItems1 = new SapItems();
            sapItems1.setVorg("vorg");
            sapItItems1.setItem(sapItems1);
            sapItItems[i] = sapItItems1;
        }
        System.out.println("========>"+ JSONObject.toJSONString(sapItItems));
        System.out.println("========>"+ JSONObject.toJSONString(sapIRoot));
    }
}
