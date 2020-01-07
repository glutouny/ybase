package com.yl.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author yangli
 * @title   FrpfHemPromotionInfo
 * @description 促销信息
 * @DATE 2019/11/25  10:04
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FrpfHemPromotionInfo implements Serializable {

    @JsonProperty("activeId")
    private String activeId;

    @JsonProperty("activeName")
    private String activeName;

    /**
     * 促销价格
     */
    @JsonProperty("discountFee")
    private Long discountFee;

    @JsonProperty("outActiveId")
    private String outActiveId;

    @JsonProperty("txdActiveId")
    private String txdActiveId;

    /**
     * 促销类型
     */
    @JsonProperty("type")
    private String type;

    @JsonProperty("voucherId")
    private String voucherId;

    public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName;
    }

    public Long getDiscountFee() {
        return discountFee;
    }

    public void setDiscountFee(Long discountFee) {
        this.discountFee = discountFee;
    }

    public String getOutActiveId() {
        return outActiveId;
    }

    public void setOutActiveId(String outActiveId) {
        this.outActiveId = outActiveId;
    }

    public String getTxdActiveId() {
        return txdActiveId;
    }

    public void setTxdActiveId(String txdActiveId) {
        this.txdActiveId = txdActiveId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(String voucherId) {
        this.voucherId = voucherId;
    }
}
