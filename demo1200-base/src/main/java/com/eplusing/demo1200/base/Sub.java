package com.eplusing.demo1200.base;

public class Sub extends Parent {
    @Override
    public int amethod(int p1, int p2) {

        return p1 * p2;
    }

    public int amethod(int p1) {

        return p1 * 8;
    }
}
