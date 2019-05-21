package com.yl.beans;

import java.util.List;

/**
 * @author yangli
 * @Title
 * @description
 * @DATE 2019/5/21  9:30
 */
public class Test {
    /**
     * logisticsInfos : [{"arrivalDate":"","carrierCode":"","carrierName":"","consignmentCode":"上海生物所K1E13成品库","driver":"","logisticsCompany":"","logisticsStage":"生产企业","optionType":"","phone":"","sendWarehouse":"","status":"已出库","telphone":"","transPortType":"","transportCode":"","unitName":"","validDate":"2018-09-04 10:30:00至2018-09-07 10:18:36","validDateFrom":"2018-09-04 10:30:00","validDateTo":"2018-09-07 10:18:36","wareHouseCode":"41"},{"arrivalDate":"1900-01-01 00:00:00","carrierCode":"92","carrierName":"沪9D8720","consignmentCode":"80137027","driver":"","logisticsCompany":"上海生物所","logisticsStage":"物流配送","optionType":"","phone":"","sendWarehouse":"","status":"已完成","telphone":"0218888888","transPortType":"车载","transportCode":"1125","unitName":"","validDate":"2018-09-07 10:18:36至2018-09-07 11:14:36","validDateFrom":"2018-09-07 10:18:36","validDateTo":"2018-09-07 11:14:36","wareHouseCode":""}]
     * message : 查询成功
     * status : S
     */

    private String message;
    private String status;
    private List<LogisticsInfosBean> logisticsInfos;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<LogisticsInfosBean> getLogisticsInfos() {
        return logisticsInfos;
    }

    public void setLogisticsInfos(List<LogisticsInfosBean> logisticsInfos) {
        this.logisticsInfos = logisticsInfos;
    }

    public static class LogisticsInfosBean {
        /**
         * arrivalDate :
         * carrierCode :
         * carrierName :
         * consignmentCode : 上海生物所K1E13成品库
         * driver :
         * logisticsCompany :
         * logisticsStage : 生产企业
         * optionType :
         * phone :
         * sendWarehouse :
         * status : 已出库
         * telphone :
         * transPortType :
         * transportCode :
         * unitName :
         * validDate : 2018-09-04 10:30:00至2018-09-07 10:18:36
         * validDateFrom : 2018-09-04 10:30:00
         * validDateTo : 2018-09-07 10:18:36
         * wareHouseCode : 41
         */

        private String arrivalDate;
        private String carrierCode;
        private String carrierName;
        private String consignmentCode;
        private String driver;
        private String logisticsCompany;
        private String logisticsStage;
        private String optionType;
        private String phone;
        private String sendWarehouse;
        private String status;
        private String telphone;
        private String transPortType;
        private String transportCode;
        private String unitName;
        private String validDate;
        private String validDateFrom;
        private String validDateTo;
        private String wareHouseCode;

        public String getArrivalDate() {
            return arrivalDate;
        }

        public void setArrivalDate(String arrivalDate) {
            this.arrivalDate = arrivalDate;
        }

        public String getCarrierCode() {
            return carrierCode;
        }

        public void setCarrierCode(String carrierCode) {
            this.carrierCode = carrierCode;
        }

        public String getCarrierName() {
            return carrierName;
        }

        public void setCarrierName(String carrierName) {
            this.carrierName = carrierName;
        }

        public String getConsignmentCode() {
            return consignmentCode;
        }

        public void setConsignmentCode(String consignmentCode) {
            this.consignmentCode = consignmentCode;
        }

        public String getDriver() {
            return driver;
        }

        public void setDriver(String driver) {
            this.driver = driver;
        }

        public String getLogisticsCompany() {
            return logisticsCompany;
        }

        public void setLogisticsCompany(String logisticsCompany) {
            this.logisticsCompany = logisticsCompany;
        }

        public String getLogisticsStage() {
            return logisticsStage;
        }

        public void setLogisticsStage(String logisticsStage) {
            this.logisticsStage = logisticsStage;
        }

        public String getOptionType() {
            return optionType;
        }

        public void setOptionType(String optionType) {
            this.optionType = optionType;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSendWarehouse() {
            return sendWarehouse;
        }

        public void setSendWarehouse(String sendWarehouse) {
            this.sendWarehouse = sendWarehouse;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTelphone() {
            return telphone;
        }

        public void setTelphone(String telphone) {
            this.telphone = telphone;
        }

        public String getTransPortType() {
            return transPortType;
        }

        public void setTransPortType(String transPortType) {
            this.transPortType = transPortType;
        }

        public String getTransportCode() {
            return transportCode;
        }

        public void setTransportCode(String transportCode) {
            this.transportCode = transportCode;
        }

        public String getUnitName() {
            return unitName;
        }

        public void setUnitName(String unitName) {
            this.unitName = unitName;
        }

        public String getValidDate() {
            return validDate;
        }

        public void setValidDate(String validDate) {
            this.validDate = validDate;
        }

        public String getValidDateFrom() {
            return validDateFrom;
        }

        public void setValidDateFrom(String validDateFrom) {
            this.validDateFrom = validDateFrom;
        }

        public String getValidDateTo() {
            return validDateTo;
        }

        public void setValidDateTo(String validDateTo) {
            this.validDateTo = validDateTo;
        }

        public String getWareHouseCode() {
            return wareHouseCode;
        }

        public void setWareHouseCode(String wareHouseCode) {
            this.wareHouseCode = wareHouseCode;
        }
    }
}
