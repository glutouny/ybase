package com.yl.util;

import org.slf4j.LoggerFactory;

import java.util.Locale;

/**
 * @author 杨黎
 * @Title LogUtil
 * @description 通用日志工具
 * @DATE 2018/6/8  11:03
 */
public class LogUtil {


    /**
     * 打印信息日志消息
     */
    public static void info(String msg) {
            LoggerFactory.getLogger(getTag()).info(buildMessage(msg));
    }

    /**
     * 打印警告日志消息
     */
    public static void warn(String msg) {
            LoggerFactory.getLogger(getTag()).warn(buildMessage(msg));
    }

    public static void warn(String msg, Throwable throwable) {
            LoggerFactory.getLogger(getTag()).warn(buildMessage(msg),throwable);
    }

    /**
     * 打印错误日志消息
     */
    public static void error(String msg, Throwable throwable) {
        /*错误信息保留*/
        LoggerFactory.getLogger(getTag()).error(buildMessage(msg), throwable);
    }
    public static void error(String msg) {
        /*错误信息保留*/
        LoggerFactory.getLogger(getTag()).error(buildMessage(msg));
    }

    public static void debug(String msg, Throwable throwable) {
        /*debug信息保留*/
        LoggerFactory.getLogger(getTag()).debug(buildMessage(msg), throwable);
    }
    public static void debug(String msg) {
        /*debug信息保留*/
        LoggerFactory.getLogger(getTag()).debug(buildMessage(msg));
    }




    private static String buildMessage(String msg) {
        StackTraceElement[] trace = new Throwable().fillInStackTrace()
                .getStackTrace();
//        String caller = "";
        String className="";
        int lineNumber = 0;
        for (int i = 2; i < trace.length; i++) {
            Class clazz = trace[i].getClass();
            if (!clazz.equals(LogUtil.class)) {
//                caller = trace[i].getMethodName();
                className=trace[i].getClassName();
                lineNumber=trace[i].getLineNumber();
                break;
            }
        }
        return String.format(Locale.US, "[%d] (%s:%d): %s ", Thread.currentThread()
                .getId(),className, lineNumber,msg);
    }

    private static String getTag() {
        StackTraceElement[] trace = new Throwable().fillInStackTrace()
                .getStackTrace();
        String callingClass = "";
        for (int i = 2; i < trace.length; i++) {
            Class clazz = trace[i].getClass();
            if (!clazz.equals(LogUtil.class)) {
                callingClass = trace[i].getClassName();
                callingClass = callingClass.substring(callingClass
                        .lastIndexOf('.') + 1);
                break;
            }
        }
        return callingClass;
    }
}
