package com.stu.guavaStu.cache;

import java.util.concurrent.ConcurrentHashMap;


/**
 * 我们这边采用Java.util.concurrent.ConcurrentHashMap来保存，
 * ConcurrentHashMap是一个线程安全的HashTable，并提供了一组和HashTable功能相同但是线程安全的方法，
 * ConcurrentHashMap可以做到读取数据不加锁，提高了并发能力。
 * 我们先不考虑内存元素回收或者在保存数据会出现内存溢出的情况，
 * 我们用ConcurrentHashMap模拟本地缓存，当在高并发环境一下，会出现一些什么问题？
 *
 * 加了 synvhionzed控制,但是性能会变差
 *
 *
 * @param <K>
 * @param <V>
 */
class TestConcurrentHashMapCache2<K, V> {
    private final ConcurrentHashMap<K, V> cacheMap = new ConcurrentHashMap<K, V>();

    public static void main(String[] args) {
        final TestConcurrentHashMapCache2<String, String> TestGuaVA = new TestConcurrentHashMapCache2<String, String>();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("T1======start========");
                Object value = TestGuaVA.getCache("key", "T1");
                System.out.println("T1 value==============" + value);
                System.out.println("T1======end========");

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T2======start========");
                Object value = TestGuaVA.getCache("key", "T2");
                System.out.println("T2 value==============" + value);
                System.out.println("T2======end========");

            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T3======start========");
                Object value = TestGuaVA.getCache("key", "T3");
                System.out.println("T3 value==============" + value);
                System.out.println("T3======end========");

            }
        });

        t1.start();
        t2.start();
        t3.start();

    }


    // 这里加上了 synchronized ,虽然能阻止缓存穿透但是与我们的设计不符合
    public synchronized Object getCache(K keyValue, String ThreadName) {
        System.out.println("ThreadName getCache==============" + ThreadName);
        Object value = null;
        //从缓存获取数据
        value = cacheMap.get(keyValue);
        //如果没有的话，把数据放到缓存
        if (value == null) {
            return putCache(keyValue, ThreadName);
        }
        return value;
    }

    public Object putCache(K keyValue, String ThreadName) {
        System.out.println("ThreadName 执行业务数据并返回处理结果的数据（访问数据库等）==============" + ThreadName);
        //可以根据业务从数据库获取等取得数据,这边就模拟已经获取数据了
        @SuppressWarnings("unchecked")
        V value = (V) "dataValue";
        //把数据放到缓存
        cacheMap.put(keyValue, value);
        return value;
    }

}
