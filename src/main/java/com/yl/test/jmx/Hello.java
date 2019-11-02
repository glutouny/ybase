package com.yl.test.jmx;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/10/31  10:16
 */
public class Hello implements HelloMBean{

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printHello() {
        System.out.println("Hello World :"+name);
    }

    @Override
    public void printHello(String name) {
        System.out.println("Hello!"+name);
    }
}
