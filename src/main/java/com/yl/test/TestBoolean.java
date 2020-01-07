package com.yl.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/12/18  11:21
 */
public class TestBoolean implements Runnable{

    public static boolean exists = true;

    public static AtomicBoolean exists_1 = new AtomicBoolean(true);

    private String name;

    public TestBoolean(String name) {
        this.name = name;
    }

    public static void main(String[] args) {

        TestBoolean testBoolean = new TestBoolean("goudan");
        TestBoolean testBoolean1 = new TestBoolean("erniu");
        new Thread(testBoolean).start();
        new Thread(testBoolean1).start();
    }

    @Override
    public  void run() {
//        if (exists) {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(name+":enter");
//            exists = false;
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(name+":leave");
//            exists = true;
//        } else {
//            System.out.println(name+":give up");
//        }
        if (exists_1.compareAndSet(true,false)) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+":enter");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+":leave");
        } else {
            System.out.println(name+":give up");
        }
    }

    public static void run_1(String name) {
        if (exists_1.get()) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+":enter");
            exists_1.set(false);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+":leave");
            exists_1.set(true);
        } else {
            System.out.println(name+":give up");
        }
    }
}
