package com.stu.com;

import java.math.BigInteger;

public class ThreadDebug01 {

    public static void main(String[] args) throws InterruptedException {

        AddThread t1 = new AddThread(10);
        AddThread t2 = new AddThread(20);
        t1.setName("Thread_1");
        t2.setName("Thread_2");
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        BigInteger re = t1.getResult().add(t2.getResult());
        System.out.println("和值:" + re);
    }

    private static class AddThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private long num;

        public AddThread(long num) {
            this.num = num;
        }

        public void run() {
            System.out.println(Thread.currentThread().getName() + "开始计算:" + num);
            add(num);
            System.out.println(Thread.currentThread().getName() + "执行完成");

        }

        public void add(long num) {
            BigInteger f = new BigInteger("1");
            for (int i = 0; i < num; i++) {
                f = f.add(BigInteger.valueOf(num));
            }
            result = f;
        }

        public BigInteger getResult() {
            return result;
        }



    }


}
