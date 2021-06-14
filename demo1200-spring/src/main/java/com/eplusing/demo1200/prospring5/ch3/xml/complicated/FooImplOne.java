package com.eplusing.demo1200.prospring5.ch3.xml.complicated;

/**
 * @author eplusing
 * @date 2020/2/19
 */
public class FooImplOne implements Foo {

    @Override
    public String sing() {
        System.out.println("FooImplOne");
        return "FooImplOne";
    }
}
