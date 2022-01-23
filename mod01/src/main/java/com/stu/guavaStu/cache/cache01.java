package com.stu.guavaStu.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class cache01 {

    public static void main(String[] args) throws InterruptedException {
        Cache<String,String> cache = CacheBuilder.newBuilder()
                .maximumSize(100) //设置缓存最大容量
                .expireAfterWrite(1, TimeUnit.SECONDS) //过期策略，写入一秒钟后过期
                .build();
        cache.put("a","a1");
        String value = cache.getIfPresent("a");
        System.out.println(value);
        Thread.sleep(1100);
        String value2 = cache.getIfPresent("a");
        System.out.println(value2);

        System.out.println("++++++++++++++++");
        HashMap<String, String> map = new HashMap<>();
        String o1 = map.putIfAbsent("key1", "val1");
        System.out.println(o1);
        String o2 = map.putIfAbsent("key1", "val2");
        System.out.println(o2);

    }
}
