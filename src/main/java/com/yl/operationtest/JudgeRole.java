package com.yl.operationtest;

import com.yl.operationtest.impl.RoleEnum;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/12/16  10:55
 */
public class JudgeRole {

    public static String judge(String roleName){
        //枚举模式
        //return RoleEnum.valueOf(roleName).op();

        //工厂模式
        return RoleFactory.getOp(roleName);
    }

    public static String judge2(RoleOperation roleOperation){
        RoleContext roleContext = new RoleContext(roleOperation);
        return roleContext.excete();
    }



}
