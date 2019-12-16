package com.yl.operationtest.impl;

import com.yl.operationtest.RoleOperation;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/12/16  11:04
 */
public class NormalRole implements RoleOperation {

    private String normalRole;

    public NormalRole(String normalRole) {
        this.normalRole = normalRole;
    }

    @Override
    public String op() {
        return "ROLE_NORMAL--BB operation"+normalRole;
    }
}
