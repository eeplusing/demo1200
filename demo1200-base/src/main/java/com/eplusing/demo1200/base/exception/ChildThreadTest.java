package com.eplusing.demo1200.base.exception;


public class ChildThreadTest implements Runnable {
    public void run() {
        //doSomething1();
        try { //可能发生异常的方法
            //exceptionMethod();
        } catch (Exception e) {//处理异常

            System.out.println(String.format("handle exception in child thread. %s", e));
        }
        //doSomething2();
    }
}
