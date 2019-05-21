package com.yl.threadtest;

import java.util.concurrent.*;

/**
 * @author 杨黎
 * @Title   ExecutorServiceTest
 * @description
 * @DATE 2019/5/15  16:59
 */
public class ThreadPoolExecutorTest {

    public static int count = 0;

    public static int getCount() {
        return count;
    }

    public synchronized  static void addCount() {
        count++;
    }


    public static void main(String[] args) throws InterruptedException {
        // 阿里规约，不允许使用Executors来创建线程池。
        ExecutorService executorService = new ThreadPoolExecutor(10,10,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));
        final int  a  = 100;
        for (int i = 0; i < a; i++) {
            if((i+1)%10 != 0){
                continue;
            }
            Runnable r = new Runnable() {

                @Override
                public void run() {
                    ThreadPoolExecutorTest.addCount();
                }
            };
            executorService.execute(r);
        }
        executorService.shutdown();
        System.out.println(ThreadPoolExecutorTest.count);
        Thread.sleep(10000);
        System.out.println(ThreadPoolExecutorTest.count+"hh");
    }
}
