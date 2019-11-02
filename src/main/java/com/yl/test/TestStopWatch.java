package com.yl.test;


import com.yl.beans.User;
import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/10/29  10:31
 */
public class TestStopWatch {

    public static void main(String[] args) throws InterruptedException {
//        testRun();
        testSystemArrayCopy();
    }

    public static void testRun() throws InterruptedException {
        StopWatch sw = new StopWatch();

        sw.start("task1");
        Thread.sleep(100);
        sw.stop();
        sw.start("task2");
        Thread.sleep(300);

        sw.stop();
        System.out.println(sw.prettyPrint());
        System.out.println(sw.getTotalTimeMillis());
    }

    public static void testSystemArrayCopy() throws InterruptedException {
        User[] users = new User[]{new User("1","1"),new User("2","2")};
        User[] targetUsers = new User[1];
        System.arraycopy(users,1,targetUsers,0,1);
        System.out.println(Arrays.asList(targetUsers));

    }
}
