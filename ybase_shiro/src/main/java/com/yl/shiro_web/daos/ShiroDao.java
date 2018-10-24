package com.yl.shiro_web.daos;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author 杨黎
 * @Title   ShiroDao
 * @description
 * @DATE 2018/10/22  19:53
 */
public interface ShiroDao {

    /**
     * 根据用户名查询密码
     * @param username
     * @return
     */
    String getPasswordByUserName(String username);

    /**
     * 查询当前用户对应的权限
     * @param username
     * @return
     */
    List<String> getPermissionByUserName(String username);
}
