package com.yl.shiro_web.services;

import java.util.List;

/**
 * @author 杨黎
 * @Title
 * @description
 * @DATE 2018/10/22  20:01
 */
public interface ShiroService {

    /**
     * 登陆
     * @param username
     * @param password
     */
    void doLogin(String username,String password) throws Exception;
    /**
     * 根据用户
     * @param username
     * @return
     */
    String getPasswordByUserName(String username);

    /**
     * 查询所有用户权限
     * @param username
     * @return
     */
    List<String> getPermissionByUserName(String username);
}
