package com.yl.operationtest;

import com.yl.operationtest.impl.AdminRole;
import com.yl.operationtest.impl.NormalRole;
import com.yl.operationtest.impl.RoleEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/12/16  11:11
 */
public class Test {

    public static void main(String[] args) {
//        System.out.println(testEnum());
        testSubString();
//        System.out.println(JudgeRole.judge("AdminRole"));
//
//        System.out.println(JudgeRole.judge2(new AdminRole("AdminRole")));
//
//        System.out.println(JudgeRole.judge2(new NormalRole("AdminRole")));
    }

    public static String testEnum() {

        try {
            return RoleEnum.valueOf("ADMIN1").op();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void testSubString() {
        String a = "aaaa";
        StringUtils.substring(a,0,3);
        System.out.println(a);
    }
}
