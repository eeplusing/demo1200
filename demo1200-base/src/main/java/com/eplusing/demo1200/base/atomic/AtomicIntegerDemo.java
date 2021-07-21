package com.eplusing.demo1200.base.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerDemo {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(11);
        integer.addAndGet(1);
    }
}
