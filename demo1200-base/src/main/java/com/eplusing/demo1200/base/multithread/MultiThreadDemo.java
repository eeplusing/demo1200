package com.eplusing.demo1200.base.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadDemo {
    static ExecutorService cachedExecutor1 = Executors.newCachedThreadPool();
    static ExecutorService cachedExecutor2 = Executors.newSingleThreadExecutor();
    static ExecutorService cachedExecutor3 = Executors.newSingleThreadScheduledExecutor();
    static ExecutorService cachedExecutor4 = Executors.newFixedThreadPool(1);
}
