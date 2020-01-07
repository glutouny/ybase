package com.yl.jdk8.optional;

import java.io.Serializable;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/11/26  15:07
 */
public class Company implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
