package com.goldcard.collection_mistakes_demo.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Slf4j
public class demo2 {
    public static void main(String[] args) {
        //Arrays.asList 返回的 List 不支持增删操作。
        // Arrays.asList 返回的 List 并不是我们期望的 java.util.ArrayList，而是 Arrays 的内部类 ArrayList。
        //ArrayList 内部类继承自 AbstractList 类，并没有覆写父类的 add 方法，而父类中 add 方法的实现，就是抛出 UnsupportedOperationException
        String[] arr = {"1", "2", "3"};
        List list = Arrays.asList(arr);
        arr[1] = "4";
        try {
            list.add("5");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        log.info("arr:{} list:{}", Arrays.toString(arr), list);

        //对原始数组的修改会影响到我们获得的那个 List。
        // 看一下 ArrayList 的实现，可以发现 ArrayList 其实是直接使用了原始的数组。
        // 所以，我们要特别小心，把通过 Arrays.asList 获得的 List 交给其他方法处理，很容易因为共享了数组，相互修改产生 Bug。

        //修改后的代码实现了原始数组和 List 的“解耦”，不再相互影响。
        //同时，因为操作的是真正的 ArrayList，add 也不再出错：
        String[] arr1 = {"1", "2", "3"};
        List list1 = new ArrayList(Arrays.asList(arr1));
        arr1[1] = "4";
        try {
            list1.add("5");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        log.info("arr1:{} list1:{}", Arrays.toString(arr1), list1);
    }
}
