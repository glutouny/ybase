package com.yl.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/11/25  10:48
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FrpfHemPromotionInfoList implements Serializable {

    @JsonProperty("promotionInfo")
    private List<FrpfHemPromotionInfo> promotionInfo;

    public List<FrpfHemPromotionInfo> getPromotionInfo() {
        return promotionInfo;
    }

    public void setPromotionInfo(List<FrpfHemPromotionInfo> promotionInfo) {
        this.promotionInfo = promotionInfo;
    }
}
