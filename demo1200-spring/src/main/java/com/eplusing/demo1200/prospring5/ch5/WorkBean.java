package com.eplusing.demo1200.prospring5.ch5;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class WorkBean {
    public void doSomeWork(int noOfTimes) {
        for (int x = 0; x < noOfTimes; x++) {
            work();
        }
    }

    private void work() {
        System.out.println("");
    }
}
