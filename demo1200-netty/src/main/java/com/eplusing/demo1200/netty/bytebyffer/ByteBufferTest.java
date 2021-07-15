package com.eplusing.demo1200.netty.bytebyffer;

import sun.misc.Cleaner;

import java.nio.ByteBuffer;

public class ByteBufferTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(1000);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            for (int j = 0; j < 200; j++) {
                buffer.putInt(j);
            }
            buffer.flip();

            for (int j = 0; j < 200; j++) {
                buffer.getInt();
            }
            buffer.clear();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("堆内存访问时间:" + (endTime - startTime) + "ms");



        ByteBuffer byteBufferDirect = ByteBuffer.allocateDirect(1000);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            for (int j = 0; j < 200; j++) {
                buffer.putInt(j);
            }
            buffer.flip();

            for (int j = 0; j < 200; j++) {
                buffer.getInt();
            }
            buffer.clear();
        }

         endTime = System.currentTimeMillis();

        Cleaner.create();
        System.out.println("直接内存访问时间:" + (endTime - startTime) + "ms");


    }

}
