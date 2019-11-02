package com.yl.test.jmx;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/10/31  10:17
 */
public interface HelloMBean {

    String getName();

    void setName(String name);

    void printHello();

    void printHello(String name);
}
