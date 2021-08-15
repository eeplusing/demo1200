package com.eplusing.demo1200.base.exception;


public class ChildThreadDemo implements Runnable {
    private static ChildThreadExceptionHandler exceptionHandler;

    static {
        exceptionHandler = new ChildThreadExceptionHandler();
    }

    @Override
    public void run() {
        Thread.currentThread().setUncaughtExceptionHandler(exceptionHandler);
        System.out.println("当前线程名称:" + Thread.currentThread().getThreadGroup() + ":" + Thread.currentThread().getName() + " do something 1");
        exceptionMethod();
        System.out.println("当前线程名称:" + Thread.currentThread().getThreadGroup() + ":" + Thread.currentThread().getName() + " do something 2");
    }

    public static class ChildThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("当前线程名称:" + Thread.currentThread().getThreadGroup() + ":" + Thread.currentThread().getName() + String.format(" UncaughtExceptionHandler handle exception in child thread. %s", e));
        }
    }

    private void exceptionMethod() {
        throw new RuntimeException("ChildThread exception");
    }
}

