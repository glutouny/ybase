package com.yl.operationtest.impl;

import com.yl.operationtest.RoleOperation;

/**
 * @author yangli
 * @title
 * @description 枚举模式
 * @DATE 2019/12/16  10:52
 */
public enum RoleEnum implements RoleOperation {

    /**
     * 管理员账号
     */
    ADMIN {
        @Override
        public String op() {
            return "ROLE_ADMIN--AA operation";
        }
    },
    /**
     * 普通账号
     */
    NORMAL {
        @Override
        public String op() {
            return "ROLE_NORMAL--BB operation";
        }
    };

}
