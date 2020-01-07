package com.yl.test;

import com.yl.beans.User;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author yangli
 * @title
 * @description
 * @DATE 2019/10/31  14:38
 */
public class TestIterator {

    public static void main(String[] args) {
        User user = new User("2","1");
        User user1 = (User) user.clone();
        System.out.println(user.hashCode()+"===="+user1.hashCode());

        Function<User,String> function = user2 -> user.getUsername();
        System.out.println(function.apply(user));

        Predicate<User> predicate = new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return "1".equals(user.getPassword());
            }
        };
        System.out.println(predicate.test(user1));
    }
}
