package com.eplusing.demo1200.base;

public class ObjectDemo implements Cloneable {

    public static void main(String[] args) {

        ObjectDemo object = new ObjectDemo();
        System.out.println("getClass:" + object.getClass());
        System.out.println("hashCode:" + object.hashCode());

        //深度copy
        Object clonedObject = null;
        try {
            //要想能够执行clone()方法，需要实现Cloneable接口。如果不实现该接口则会抛出CloneNotSupportedException异常

            //浅copy只copy基本类型和引用，对copy前对象的修改还会导致copy后对象变化
            //深copy对基本类型进行copy，对引用类型再进行clone
            clonedObject = object.clone();
            System.out.println(clonedObject);

            System.out.println(object.equals(clonedObject));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }


     /*   try {
            Thread.currentThread().wait(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        //object.notify();
        //object.notifyAll();
        System.out.println("notifyAll");

    /*    try {
            object.wait();
            object.wait(3000l);
            System.out.println("object.wait");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        Thread thread = Thread.currentThread();
        try {
            thread.sleep(3000l);
            System.out.println("thread.sleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            object.finalize();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        try {
            clonedObject = object.clone();
            System.out.println(clonedObject);

            System.out.println(object.equals(clonedObject));

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

}
