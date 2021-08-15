package com.eplusing.demo1200.redis;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

public class Ticket {

    private static CountDownLatch ctl = new CountDownLatch(1);

    Integer stock = 8;

    public static void main(String[] args) throws InterruptedException {

        final Ticket ticket = new Ticket();

        for (int i = 0; i < 10; i++) {
            //new Thread(() -> ticket.reduce(1), "用户" + (i + 1)).start();
            //new Thread(() -> ticket.reduceByLock(1), "用户" + (i + 1)).start();
            new Thread(() -> ticket.reduceByDistributeLock(1), "用户" + (i + 1)).start();
        }

        Thread.sleep(1000L);

        ctl.countDown();
    }

    private void reduce(int num) {
        if (stock - num >= 0) {
            try {
                ctl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            stock -= num;
            System.out.println(Thread.currentThread().getName() +
                    "成功卖出" + num + "张，剩余" + stock + "张");

        } else {
            System.out.println(Thread.currentThread().getName() +
                    "库存不足，不能卖出" + num + "张，剩余" + stock + "张");
        }


    }

    private synchronized void reduceByLock(int num) {
        if (stock - num >= 0) {
            try {
                ctl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            stock -= num;
            System.out.println(Thread.currentThread().getName() +
                    "成功卖出" + num + "张，剩余" + stock + "张");

        } else {
            System.out.println(Thread.currentThread().getName() +
                    "库存不足，不能卖出" + num + "张，剩余" + stock + "张");
        }


    }

    private void reduceBySynBlockLock(int num) {
        synchronized (stock) {
            if (stock - num >= 0) {
                try {
                    ctl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stock -= num;
                System.out.println(Thread.currentThread().getName() +
                        "成功卖出" + num + "张，剩余" + stock + "张");

            } else {
                System.out.println(Thread.currentThread().getName() +
                        "库存不足，不能卖出" + num + "张，剩余" + stock + "张");
            }

        }


    }

    private void reduceByDistributeLock(int num) {
        RedisLockDemo lock = new RedisLockDemo();
        String requestId = UUID.randomUUID().toString();
        lock.lock("stockXioamingLaiLiao", requestId);
        try {
            if (stock - num >= 0) {
                try {
                    ctl.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                stock -= num;
                System.out.println(Thread.currentThread().getName() +
                        "成功卖出" + num + "张，剩余" + stock + "张");
            } else {
                System.out.println(Thread.currentThread().getName() +
                        "库存不足，不能卖出" + num + "张，剩余" + stock + "张");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock("stockXioamingLaiLiao", requestId);
        }

    }
}
