package com.stu.guavaStu.cache;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


/**
 *   线程T1或者线程T2访问cacheMap，如果都没有时，这时执行了FutureTask来完成异步任务，
 *   假如线程T1执行了FutureTask，并把保存到ConcurrentHashMap中，通过PutIfAbsent方法，
 *   因为putIfAbsent方法如果不存在key对应的值，则将value以key加入Map，否则返回key对应的旧值。
 *   这时线程T2进来时可以获取Future对象，如果没值没关系，
 *   这时是对象的引用，等FutureTask执行完，在通过get返回
 * @param <K>
 * @param <V>
 */
public class TestConcurrentHashMapCache3<K, V> {

    // 注意比较这两种设置的区别,对并发的影响
//    private final ConcurrentHashMap<K, Future<V>> cacheMap = new ConcurrentHashMap<K, Future<V>>();

    private final HashMap<K, Future<V>> cacheMap = new HashMap<K, Future<V>>();

    private static int threadCount = 200;

    public static void main(String[] args) {
        final TestConcurrentHashMapCache3<String, String> TestGuaVA = new TestConcurrentHashMapCache3<String, String>();
        for (int i = 0; i < threadCount; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Object value = TestGuaVA.getCache("key", Thread.currentThread().getName());
                    System.out.println(Thread.currentThread().getName() + "==============" + value);

                }
            }).start();
        }

    }

    public Object getCache(K keyValue, String ThreadName) {
        Future<V> value = null;
        try {
            System.out.println("ThreadName getCache==============" + ThreadName);
            //从缓存获取数据
            value = cacheMap.get(keyValue);
            //如果没有的话，把数据放到缓存
            if (value == null) {
                value = putCache(keyValue, ThreadName);
                return value.get();
            }
            return value.get();

        } catch (Exception e) {
        }
        return null;
    }

    public Future<V> putCache(K keyValue, final String ThreadName) throws InterruptedException {
        Future<V> value = null;
        Callable<V> callable = new Callable<V>() {
            @SuppressWarnings("unchecked")
            @Override
            public V call() throws Exception {
                //可以根据业务从数据库获取等取得数据,这边就模拟已经获取数据了
                System.out.println("ThreadName 执行业务数据并返回处理结果的数据（访问数据库等）==============" + ThreadName);
                return (V) "dataValue";
            }
        };
        FutureTask<V> futureTask = new FutureTask<V>(callable);
        Thread.sleep(500);
        value = cacheMap.putIfAbsent(keyValue, futureTask);
        // 这里即使有两个线程进来都判断为null,是有可能执行两次run 方法的吗?
        // 在cacheMap为 ConcurrentHashMap类型时无需担心有多个判断同时进来
        // 但是若是 HsahMAp 则完全有可能多个一起进来
        // 若使用HashMap,则要保证 future生成的是单例(可参考单例模式验证)
        if (value == null) {
            value = futureTask;
            futureTask.run();
        }
        return value;
    }


}
