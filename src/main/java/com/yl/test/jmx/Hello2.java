package com.yl.test.jmx;

import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/10/31  10:16
 */
@ManagedResource
public class Hello2 implements HelloMBean{

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
        System.out.println("Hello World Hello World :"+name);
    }

    @Override
    public void printHello(String name) {
        System.out.println("Hello!Hello!"+name);
    }
}
