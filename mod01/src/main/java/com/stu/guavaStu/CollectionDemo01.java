package com.stu.guavaStu;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//        Lists
//        各种创建list的方法
//        asList()将数据组转成list
//        newArrayList()
//        newArrayListWithCapacity(10) 指定容量的创建
//        newArrayListWithExpectedSize（20） 初始化指定容量
//        newCopyOnWriteArrayList()
//        newLinkedList()
//        partition(List list, int size) 将list按指定大小分隔成多个list
//        cartesianProduct(List<? extends B>… lists) 获取多个list的笛卡尔集
//        charactersOf(String str) 将字符串转成字符集合
//        reverse(List list) 反转list
//        transform(List fromList, Function<? super F, ? extends T> function) 数据转换
public class CollectionDemo01 {
    public static void main(String[] args) {

        List<Object> asList1 = Lists.asList("1", 2, new Object[]{"a", "b"});
        // [1, 2, a, b]
        // Returns an unmodifiable list containing the specified first and second element,
        // and backed by the specified array of additional elements.
        System.out.println(asList1);
        // 不可变列表，不能add
//        asList1.add(100);
//        System.out.println(asList1);

        // 这里考虑到扩容机制，先根据预估值生成一个List，方便性能
        ArrayList<Object> asList2 = Lists.newArrayListWithExpectedSize(3);
        asList2.add(100);
        asList2.add(200);
        asList2.add(300);
        asList2.add(400);
        asList2.add(500);
        asList2.add(600);
        asList2.add(700);
        System.out.println(asList2);

        // [[100, 200], [300, 400], [500, 600], [700]]
        // 将list按指定大小分隔成多个list
        List<List<Object>> partition = Lists.partition(asList2, 2);
        System.out.println(partition);

        List<String> list1 = Lists.newArrayList("a","b","c");
        List<String> list2 = Lists.newArrayList("d","e","f");
        List<String> list3 = Lists.newArrayList("1","2","3");
        //获取多个list的笛卡尔集
        List<List<String>> list = Lists.cartesianProduct(list1,list2,list3);
        // 27组 List<List<String>>
        System.out.println(list);

        List<String> listx = Lists.newArrayList("a","b","c");
        //把list中的每个元素拼接一个1
        listx = Lists.transform(listx,str -> str + "1");
        System.out.println(listx);

        HashSet<String> strings = Sets.newHashSet(listx);
        Set<Set<String>> sets = Sets.powerSet(strings);
        // powerSet({a1=0, c1=1, b1=2})
        System.out.println(sets);
        // com.google.common.collect.Sets$PowerSet
        System.out.println(sets.getClass().getName());

    }












}
