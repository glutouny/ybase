package com.yl.operationtest;

/**
 * @author yangli
 * @title
 * @description 策略模式
 * @DATE 2019/12/16  11:19
 */
public class RoleContext {

    private RoleOperation roleOperation;

    public RoleContext(RoleOperation roleOperation) {
        this.roleOperation = roleOperation;
    }

    public String excete(){
        return roleOperation.op();
    }
}
