package com.stu.guavaStu;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;

public class CollectionDemo02 {

    public static void main(String[] args) {
        Set<String> set = Sets.newHashSet("a","b","c","c");
        //将set转成Map,key为set元素,value为每个元素的长度
        Map<String,Integer> map = Maps.asMap(set,String::length);
        //   {a=1, b=1, c=1}
        System.out.println(map);

        Map<String,String> map1 = Maps.newHashMap();
        map1.put("a","1");
        map1.put("b","2");
        map1.put("c","3");
        Map<String,String> map2 = Maps.newHashMap();
        map2.put("a","1");
        map2.put("e","5");
        map2.put("f","6");
        //mapDifference是将两个map相同的部分剔除
        MapDifference<String,String> mapDifference = Maps.difference(map1,map2);
        //两个Map相同的部分
        System.out.println(mapDifference.entriesInCommon());
        //左边集合剔除相同部分后的剩余
        System.out.println(mapDifference.entriesOnlyOnLeft());
        //右边集合剔除相同部分后的剩余
        System.out.println(mapDifference.entriesOnlyOnRight());

        Map<String,String> map3 = Maps.newHashMap();
        map3.put("a","1");
        map3.put("b","2");
        map3.put("c","3");
        Map<String,String> result = Maps.filterEntries(map3,item -> !item.getValue().equalsIgnoreCase("2"));
        // {a=1, c=3}
        System.out.println(result);


        Map<String,String> mapE = Maps.newHashMap();
        mapE.put("a","1");
        mapE.put("b","2");
        mapE.put("c","3");
        Map<String,String> result1 = Maps.transformEntries(mapE,(k,v) -> k + v);
        System.out.println(result1);

    }
}
