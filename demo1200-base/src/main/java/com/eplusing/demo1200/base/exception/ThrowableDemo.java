package com.eplusing.demo1200.base.exception;

public class ThrowableDemo {

    Throwable throwable = new Throwable();

    Error error = new Error();

    Exception exception = new Exception();

    RuntimeException runtimeException = new RuntimeException();

    public static void main(String[] args) {
        System.out.println("主线程名称:" + Thread.currentThread().getThreadGroup() + ":" + Thread.currentThread().getName());

        ChildThreadDemo childThreadDemo1 = new ChildThreadDemo();
        new Thread(childThreadDemo1).start();

        ChildThreadDemo2 childThreadDemo2 = new ChildThreadDemo2();
        new Thread(childThreadDemo2).start();
    }

}
