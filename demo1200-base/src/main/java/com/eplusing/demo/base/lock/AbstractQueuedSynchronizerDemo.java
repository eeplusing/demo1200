package com.eplusing.demo.base.lock;

import java.util.concurrent.locks.ReentrantLock;

public class AbstractQueuedSynchronizerDemo {



    public static void main(String[] args) {
        //true公平锁
        ReentrantLock fairReentrantLock = new ReentrantLock(true);

        fairReentrantLock.lock();
     /*
    1.该方法会首先判断当前状态，如果c==0说明没有线程正在竞争该锁，如果不c !=0 说明有线程正拥有了该锁。
    2.如果发现c==0，则通过CAS设置该状态值为acquires,acquires的初始调用值为1，每次线程重入该锁都会+1，每次unlock都会-1，
    但为0时释放锁。如果CAS设置成功，则可以预计其他任何线程调用CAS都不会再成功，也就认为当前线程得到了该锁，
    也作为Running线程，很显然这个Running线程并未进入等待队列。
    3.如果c !=0 但发现自己已经拥有锁，只是简单地++acquires，并修改status值，但因为没有竞争，所以通过setStatus修改，
    而非CAS，也就是说这段代码实现了偏向锁的功能，并且实现的非常漂亮。


     final boolean nonfairTryAcquire(int acquires) {
            final Thread current = Thread.currentThread();
            int c = getState();
            if (c == 0) {
                if (compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(current);
                    return true;
                }
            }
            else if (current == getExclusiveOwnerThread()) {
                int nextc = c + acquires;
                if (nextc < 0) // overflow
                    throw new Error("Maximum lock count exceeded");
                setState(nextc);
                return true;
            }
            return false;
        }*/







        //默认false非公平锁
        ReentrantLock unfairReentrantLock = new ReentrantLock(false);
        unfairReentrantLock.lock();
    }
}
