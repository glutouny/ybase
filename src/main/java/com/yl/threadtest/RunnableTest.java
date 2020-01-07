package com.yl.threadtest;

import java.util.concurrent.Callable;

/**
 * @author 杨黎
 * @Title   RunnableTest
 * @description
 * @DATE 2019/5/15  16:52
 */
public class RunnableTest {

    public static void main(String[] args) throws Exception {
        final int a = 5;
        for (int i = 0; i < a; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("啦啦啦啦啦");
                }
            });
            thread.start();
        }
    }
}
