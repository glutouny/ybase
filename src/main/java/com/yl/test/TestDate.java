package com.yl.test;


import java.util.Calendar;
import java.util.Date;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/11/14  9:26
 */
public class TestDate {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DATE,-1);
        System.out.println(calendar.getTime());


    }
}
