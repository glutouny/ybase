package com.yl.jdk8.filtration;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 杨黎
 * @Title
 * @description
 * @DATE 2018/10/15  15:54
 */
public class Filter {


    /**
     *  filter()：接受一个谓词，返回符合条件的元素集合
     * distinct() : 去重
     **/
    public static void filterTest01() {
        List<String> list = Arrays.asList("悟空", "", "唐僧", "八戒", "悟净", "白龙马", "白龙马");

        List<String> newList = list.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList());
        List<String> newList1 = list.stream().distinct().collect(Collectors.toList());
        //结果：newList=("悟空","唐僧","八戒","悟净","白龙马")
        newList1.forEach(System.out::println);
        System.out.println("============");
        newList.forEach(System.out::println);
    }

    /**
     * 求偶数
     **/
    public static void filterTest02() {
        Integer[] nums = {1, 2, 3, 4, 5, 6};
        //求偶数个数
        long longcount = Stream.of(nums).filter(n -> n % 2 == 0).count();
        //求偶数
        Integer[] evenNums = Stream.of(nums).filter(n -> n % 2 == 0).toArray(Integer[]::new);

        //结果：evenNums=[2, 4,6]

        System.out.println(Arrays.toString(evenNums));
    }
    /**匹配**/
    public void testMatch() {
        Integer[] nums = {2, 3, 5, 6, 7, 9, 8};
        //是否有存在偶数.
        boolean booleanisEven = Arrays.stream(nums).anyMatch(n -> n % 2 == 0);
        //结果：isEven=true
        System.out.println("isEven=" + booleanisEven);

        //是否全部是偶数.
        boolean booleanisEvenAll = Arrays.stream(nums).allMatch(n -> n % 2 == 0);
        //结果：isEvenAll=false
        System.out.println("isEvenAll=" + booleanisEvenAll);

        //是否全部不是偶数
        boolean booleannoneMatch = Arrays.stream(nums).noneMatch(n -> n % 2 == 0);
        //结果：noneMatch=false
        System.out.println("noneMatch=" + booleannoneMatch);
    }
    /**
     * 查找
     * findFirst()和findAny():如果不在一返回的元素是哪个，使用findAny()，因为它在使用并行流时限制较少。
     * **/
    public void find(){
        List<Integer> someNumbers = Arrays.asList(1,2, 3, 4, 5,6);

        //找到第一个能够被3整除的数
        Optional<Integer> findFirstOptional = someNumbers.stream().filter(x -> x % 3 == 0).findFirst();

        //结果：3
        System.out.println(findFirstOptional.get());

        findFirstOptional = someNumbers.stream().filter(x -> x % 3 == 0).findAny();
        //结果：3
        System.out.println(findFirstOptional.get());
    }

    /**
     * 归约:在汇总结合内所有数据的时候使用。比如求 max，min，sum。
     */
    public void get(){
        List<Integer> integers = Arrays.asList(1,2, 3, 4, 5);

        IntSummaryStatistics stats = integers.stream().mapToInt((x) -> x).summaryStatistics();

        //列表中最大的数 : 5

        System.out.println("列表中最大的数 : " + stats.getMax());

        //列表中最小的数 : 1

        System.out.println("列表中最小的数 : " + stats.getMin());

        //所有数之和 : 15

        System.out.println("所有数之和 : " + stats.getSum());

        //平均数 : 3.0

        System.out.println("平均数 :" + stats.getAverage());
    }

    public static void main(String[] args) {
        filterTest01();
    }
}
