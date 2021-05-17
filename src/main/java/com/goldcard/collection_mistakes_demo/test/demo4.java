package com.goldcard.collection_mistakes_demo.test;

/**
 * 浙江金卡智能集团股份有限公司
 *
 * @author G001933
 * @version v1.0
 * @className demo4.java
 * @date 2021/5/17 19:06
 * @description MySQL 中有关 NULL 的三个坑
 */
public class demo4 {
    /**
     * 1、MySQL 中 sum 函数没统计到任何记录时，会返回 null 而不是 0，可以使用 IFNULL 函数把 null 转换为 0；
     * 2、MySQL 中 count 字段不统计 null 值，COUNT(*) 才是统计所有记录数量的正确方式。
     * 3、MySQL 中使用诸如 =、<、> 这样的算数比较操作符比较 NULL 的结果总是 NULL，这种比较就显得没有任何意义，需要使用 IS NULL、IS NOT NULL 或 ISNULL() 函数来比较。
     */
}
