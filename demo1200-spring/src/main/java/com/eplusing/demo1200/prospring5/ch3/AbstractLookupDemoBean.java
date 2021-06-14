package com.eplusing.demo1200.prospring5.ch3;

/**
 * @author eplusing
 * @date 2020/2/12
 */
public abstract class AbstractLookupDemoBean implements DemoBean {

    @Override
    public abstract Singer getMySinger();

    @Override
    public void doSomething() {
        getMySinger().sing();
    }
}
