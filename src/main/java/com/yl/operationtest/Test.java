package com.yl.operationtest;

import com.yl.operationtest.impl.AdminRole;
import com.yl.operationtest.impl.NormalRole;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/12/16  11:11
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(JudgeRole.judge("AdminRole"));

        System.out.println(JudgeRole.judge2(new AdminRole("AdminRole")));

        System.out.println(JudgeRole.judge2(new NormalRole("AdminRole")));
    }
}
