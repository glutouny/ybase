package com.yl.shiro_web.daos.impl;

import com.yl.shiro_web.daos.ShiroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author 杨黎
 * @Title ShiroDaoImpl
 * @description
 * @DATE 2018/10/22  19:57
 */
public class ShiroDaoImpl implements ShiroDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String getPasswordByUserName(String username) {
        String sql = "select PASSWORD from SHIRO_USER where USER_NAME = ?";
        String password = jdbcTemplate.queryForObject(sql, String.class, username);
        return password;
    }

    @Override
    public List<String> getPermissionByUserName(String username) {
        String sql = "select P.PERM_NAME from SHIRO_ROLE_PERMISSION P inner join SHIRO_USER_ROLE R on P.ROLE_NAME=R.ROLE_NAME where R.USER_NAME = ?";
        List<String> perms = jdbcTemplate.queryForList(sql, String.class, username);
        return perms;
    }
}
