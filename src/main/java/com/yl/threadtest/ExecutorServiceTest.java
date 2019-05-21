package com.yl.threadtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author 杨黎
 * @Title   ExecutorServiceTest
 * @description
 * @DATE 2019/5/15  16:59
 */
public class ExecutorServiceTest {

    public static void main(String[] args) {
        // 阿里规约，不允许使用Executors来创建线程池。
        ExecutorService executorService = Executors.newCachedThreadPool();
        final int a = 10;
        for (int i = 0; i < a; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    System.out.println("啦啦啦啦啦"+Thread.currentThread().getName());
                }
            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }
}
