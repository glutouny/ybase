/*
 * Copyright (C) HAND Enterprise Solutions Company Ltd.
 * All Rights Reserved
 */
package com.yl.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author 杨黎
 * @Title DoubleCalculate
 * @Description
 * @date 2018/8/10
 */
public class DoubleCalculate {

    private static int DEF_DIV_SCALE = 10;

    /**
     * 提供精确的减法运算
     *
     * @param v1
     *           被减数
     * @param v2
     *           减数
     * @return 两个参数的差
     */
    public static double sub(final double v1, final double v2)
    {
        final BigDecimal b1 = new BigDecimal(Double.toString(v1));
        final BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的加法运算
     *
     * @param v1
     *           被加数
     * @param v2
     *           加数
     * @return 两个参数的和
     */
    public static double add(final double v1, final double v2)
    {
        final BigDecimal b1 = new BigDecimal(Double.toString(v1));
        final BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算。
     *
     * @param v1
     *           被乘数
     * @param v2
     *           乘数
     * @return 两个参数的积
     */
    public static double mul(final double v1, final double v2)
    {
        final BigDecimal b1 = new BigDecimal(Double.toString(v1));
        final BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
     *
     * @param v1
     *           被除数
     * @param v2
     *           除数
     * @return 两个参数的商
     */
    public static double div(final double v1, final double v2)
    {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
     *
     * @param v1
     *           被除数
     * @param v2
     *           除数
     * @param scale
     *           表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(final double v1, final double v2, final int scale)
    {
        if (scale < 0)
        {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        final BigDecimal b1 = new BigDecimal(Double.toString(v1));
        final BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param v
     *           需要四舍五入的数字
     * @param scale
     *           小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(final double v, final int scale)
    {

        if (scale < 0)
        {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        final BigDecimal b = new BigDecimal(Double.toString(v));
        final BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 格式化保留两位小数
     */
    public static String format(final double doubleValue){
        final NumberFormat nf = new DecimalFormat("0.00");
        return nf.format(doubleValue);
    }

}
