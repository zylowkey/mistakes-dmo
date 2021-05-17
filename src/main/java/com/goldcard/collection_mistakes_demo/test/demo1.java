package com.goldcard.collection_mistakes_demo.test;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
@Slf4j
public class demo1 {
    public static void main(String[] args) {
        //不能直接使用 Arrays.asList 来转换基本类型数组
        int[] arr = {1, 2, 3};
        List list = Arrays.asList(arr);
        log.info("list:{} size:{} class:{}", list, list.size(), list.get(0).getClass());

        Integer[] arr1 = {1, 2, 3};
        List list1 = Arrays.asList(arr1);
        log.info("list:{} size:{} class:{}", list1, list1.size(), list1.get(0).getClass());

    }
}
