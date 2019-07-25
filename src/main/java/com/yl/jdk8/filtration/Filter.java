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
        String conent = "【订单关联合同】:您有[1]张预借苗订单：[2]尚未关联合同，请及时关联并尽快确认开票。";
        int count = 2;
        String message = "0012345678（数量10）、30001653 （数量3000）";
        System.out.println(conent.replace("[1]",String.valueOf(count)).replace("[2]",message));
    }
}
