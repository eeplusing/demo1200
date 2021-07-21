package com.eplusing.demo1200.base.list;

import java.sql.DriverManager;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {
   //用于读多写少的操作
    //jdbc驱动类中使用该类
   private CopyOnWriteArrayList copyOnWriteArrayList;
   DriverManager driverManager;

   public static void main(String[] args) {
      CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

      copyOnWriteArrayList.add("1");
      copyOnWriteArrayList.get(1);
   }


}
