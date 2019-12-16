package com.yl.operationtest.impl;

import com.yl.operationtest.RoleOperation;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/12/16  11:04
 */
public class AdminRole implements RoleOperation {

    private String adminRole;

    public AdminRole(String adminRole) {
        this.adminRole = adminRole;
    }

    @Override
    public String op() {
        return "ROLE_ADMIN--AA operation"+adminRole;
    }
}
