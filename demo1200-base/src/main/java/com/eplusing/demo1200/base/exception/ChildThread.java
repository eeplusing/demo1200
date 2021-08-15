package com.eplusing.demo1200.base.exception;


import java.util.concurrent.Callable;

public class ChildThread implements Callable {
    public String call() throws Exception {
        System.out.println("当前线程名称:" + Thread.currentThread().getThreadGroup() + ":" + Thread.currentThread().getName() + "do something 1");
        exceptionMethod();
        System.out.println("当前线程名称:" + Thread.currentThread().getThreadGroup() + ":" + Thread.currentThread().getName() + "do something 2");
        return "test result";
    }

    private void exceptionMethod() {
        throw new RuntimeException("当前线程名称:" + Thread.currentThread().getThreadGroup() + ":" + Thread.currentThread().getName() + "ChildThread1 exception");
    }
}

