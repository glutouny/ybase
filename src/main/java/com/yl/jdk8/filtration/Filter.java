package com.yl.jdk8.filtration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 杨黎
 * @Title   Filter
 * @description 过滤筛选Test  filter()：接受一个谓词，返回符合条件的元素集合
 * @DATE 2018/10/15  15:54
 */
public class Filter {



    /**
     *
     */

    public void filterTest(){
        List<String> list = Arrays.asList("悟空","","唐僧","八戒","悟净","白龙马");

        List<String> newList = list.stream().filter(str -> str.isEmpty()).collect(Collectors.toList());
//        List<String> newList = list.stream().filter(str->!str.isEmpty()).collect(Collectors.toList());
        //结果：newList=("悟空","唐僧","八戒","悟净","白龙马")

        newList.forEach(System.out::println);
    }

    public static void main(String[] args) {

    }
}
