package com.yl.threadTest.bean;

/**
 * Title InterfaceConfigBean
 * Description 接口配置Bean
 * author yangli
 * date 2018/10/16 09:27
 */
public class InterfaceConfigBean {

    private String code; //编码
    private String resourceUrl; //访问的url
    private String userName; //用户名
    private String password; //密码
    private String description; //接口名称
    private Integer payload; //请求数量
    private Integer threadNum; //并发数量
    private String ip; //IP
    private String port; //端口
    private Boolean enabledFlag; //启用标识

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPayload() {
        return payload;
    }

    public void setPayload(Integer payload) {
        this.payload = payload;
    }

    public Integer getThreadNum() {
        return threadNum;
    }

    public void setThreadNum(Integer threadNum) {
        this.threadNum = threadNum;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Boolean getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Boolean enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

}
