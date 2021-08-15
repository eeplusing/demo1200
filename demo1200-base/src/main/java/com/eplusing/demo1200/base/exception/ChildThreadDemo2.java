package com.eplusing.demo1200.base.exception;

public class ChildThreadDemo2 implements Runnable {
    private static ChildThreadExceptionHandler exceptionHandler;

    static {
        exceptionHandler = new ChildThreadExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler);
    }
    @Override
    public void run() {
        System.out.println("当前线程名称:" + Thread.currentThread().getThreadGroup() + ":" + Thread.currentThread().getName() + " do something 1");
        exceptionMethod();
        System.out.println("当前线程名称:" + Thread.currentThread().getThreadGroup() + ":" + Thread.currentThread().getName() + " do something 2");
    }



    private void exceptionMethod() {
        throw new RuntimeException("ChildThread exception");
    }

    public static class ChildThreadExceptionHandler implements Thread.UncaughtExceptionHandler {
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("当前线程名称:" + Thread.currentThread().getThreadGroup() + ":" + Thread.currentThread().getName() +String.format(" DefaultUncaughtExceptionHandler handle exception in child thread. %s", e));
        }
    }
}

