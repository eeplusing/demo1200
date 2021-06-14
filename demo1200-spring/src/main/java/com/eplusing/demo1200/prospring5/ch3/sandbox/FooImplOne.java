package com.eplusing.demo1200.prospring5.ch3.sandbox;

import org.springframework.stereotype.Component;

/**
 * @author eplusing
 * @date 2020/2/18
 */
@Component
public class FooImplOne implements Foo
{
    @Override
    public String sing() {
        System.out.println("FooImplOne");
        return "FooImplOne";
    }
}
