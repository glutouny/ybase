package com.yl.operationtest;

import com.yl.operationtest.impl.AdminRole;
import com.yl.operationtest.impl.NormalRole;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangli
 * @title 工厂模式
 * @description
 * @DATE 2019/12/16  11:09
 */
public class RoleFactory {

    static Map<String,RoleOperation> roleOperationMap = new HashMap<>();

    static {
        roleOperationMap.put("AdminRole",new AdminRole("AdminRole"));
        roleOperationMap.put("NormalRole",new NormalRole("NormalRole"));
    }

    public static String getOp(String roleName) {
       return  roleOperationMap.get(roleName).op();
    }
}
