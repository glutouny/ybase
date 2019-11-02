package com.yl.beans;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/5/29  19:43
 */
public class SapItItems {
    private SapItems item;

    private Date dateTime;

    private Date creationTime;

    private String code;

    public SapItems getItem() {
        return item;
    }

    public void setItem(SapItems item) {
        this.item = item;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
