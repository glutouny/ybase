package com.yl.test;

import com.yl.util.DoubleCalculate;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/11/22  10:39
 */
public class TestDouble {
    public static void main(String[] args) {
//        testBigDecimal();
        testAtoMicInteger();

//        Boolean inv = Boolean.TRUE;
//        String str = "";
//        StringBuilder str1  = new StringBuilder();
//        System.out.println(StringUtils.isEmpty(str1));
//        testBoolean(inv,str,str1);
//        System.out.println(inv.toString()+"==="+str+"-----"+str1.toString());
    }

    public static void testdouble(){
        double a  = 1.1;
        double b = 0.12;
        int c = 1;
        System.out.println(a+b);

        System.out.println(DoubleCalculate.add(a,b));

        System.out.println(a*c);
    }

    public static void testBigDecimal(){
        double a = 20d;
        int b = 3;
        final BigDecimal bigDecimal1 = new BigDecimal(String.valueOf(a));
        final BigDecimal bigDecimal2 = new BigDecimal(String.valueOf(b));
        double c = bigDecimal1.divide(bigDecimal2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(c);
    }

    private static void testBoolean(Boolean inv,String str,StringBuilder str1) {
        inv = Boolean.FALSE;
        str = "111";
        str1.append("2222222222");
    }

    public static void testAtoMicInteger(){
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (int i =0;i < 10;i++) {

            if (atomicInteger.getAndIncrement() < 1) {
                System.out.println("bbbbbbbbbbbbbbb"+atomicInteger);
            } else {
                atomicInteger.decrementAndGet();
                System.out.println("ccccccccccccc"+atomicInteger);
            }
        }
        atomicInteger.decrementAndGet();
        System.out.println("aaaaaaaaaaaaa"+atomicInteger);


    }
}
