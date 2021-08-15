package com.eplusing.demo1200.base.exception;

import java.util.concurrent.*;

public class ClassMain {
    public static void main2(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        Future future = executorService.submit(new ChildThread());
        try {
            Object o = future.get();
            System.out.println(o);
        } catch (InterruptedException e) {
            System.out.println(String.format("handle exception in child thread. %s", e));
        } catch (ExecutionException e) {
            System.out.println(String.format("handle exception in child thread. %s", e));
            System.out.println("原始异常：" + e.getCause());
        } finally {
            if (executorService != null) {
                executorService.shutdown();
            }
        }
    }


    public static void main(String[] args) {
        // 1.创建Callable实现对象
        ChildThread threadDemo = new ChildThread();
        // 2.创建FutureTask对象
        FutureTask<String> futureTask = new FutureTask<String>(threadDemo);
        // 3.创建Thread对象
        Thread thread = new Thread(futureTask);
        // 4.启动线程
        thread.start();
        // 获取线程返回值
        try {
            String callReturn = futureTask.get(); // 会一直等待线程结束获取其返回值，如果线程被中断会抛异常
            System.out.println(callReturn);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }




}

