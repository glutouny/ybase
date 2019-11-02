package com.yl.test;

import com.yl.beans.User;

import java.util.function.UnaryOperator;

/**
 * @author yangli
 * @title   TestLambda
 * @description
 * @DATE 2019/10/25  10:36
 */
public class TestLambda {

    public static void main(String[] args) {
        UnaryOperator<Boolean> unaryOperator = uglily -> !uglily;
        Boolean apply2 = unaryOperator.apply(true);
        System.out.println(apply2);


    }
}
