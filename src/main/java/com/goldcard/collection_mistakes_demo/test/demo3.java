package com.goldcard.collection_mistakes_demo.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
@Slf4j
public class demo3 {

    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        log.info("list{}",list);
        List<Integer> subList = list.subList(1, 4);
        log.info("subList{}",subList);
        subList.remove(1);
        log.info("list{}",list);
        list.add(0);
        try {
            subList.forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //SubList 相当于原始 List 的视图，那么避免相互影响的修复方式有两种：
        //不直接使用 subList 方法返回的 SubList，而是重新使用 new ArrayList，在构造方法传入 SubList，来构建一个独立的 ArrayList；
        //对于 Java 8 使用 Stream 的 skip 和 limit API 来跳过流中的元素，以及限制流中元素的个数，同样可以达到 SubList 切片的目的
        List<Integer> list1 = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
        log.info("list1{}",list1);
        List<Integer> subList1 = new ArrayList<>(list1.subList(1, 4));
        log.info("subList1{}",subList1);
        subList1.remove(1);
        log.info("list1{}",list1);
        log.info("subList1{}",subList1);
        list1.add(0);
        log.info("list1{}",list1);
        try {
            subList1.forEach(System.out::println);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
