package com.yl.beans;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/5/29  19:42
 */
public class SapIRoot {

    private SapItHead I_HEAD;

    private SapItItems[] Iitems;

    public SapItHead getI_HEAD() {
        return I_HEAD;
    }

    public void setI_HEAD(SapItHead i_HEAD) {
        I_HEAD = i_HEAD;
    }

    public SapItItems[] getIitems() {
        return Iitems;
    }

    public void setIitems(SapItItems[] iitems) {
        Iitems = iitems;
    }
}
