package com.yl.storefront.ajax;

import java.io.Serializable;
import java.util.Map;

/**
 * @author 杨黎
 * @Title   ResultBean
 * @description ajax返回结果
 * @DATE 2018/10/16  9:05
*/
public class ResultBean<T>  implements Serializable {
    private int code;
    private T datas;
    private String msg;
    private boolean success;
    private Integer total;
    private Map<String,String> sortInfo;
    private String status;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Map<String, String> getSortInfo() {
        return sortInfo;
    }

    public void setSortInfo(Map<String, String> sortInfo) {
        this.sortInfo = sortInfo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
