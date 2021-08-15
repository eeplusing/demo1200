package com.eplusing.demo1200.base.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);  // true：公平锁

        Condition aConditio = reentrantLock.newCondition();
        Condition bConditio = reentrantLock.newCondition();
        Condition cConditio = reentrantLock.newCondition();

    }
}
