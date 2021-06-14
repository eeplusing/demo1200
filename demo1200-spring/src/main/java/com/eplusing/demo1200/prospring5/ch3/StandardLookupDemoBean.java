package com.eplusing.demo1200.prospring5.ch3;

/**
 * @author eplusing
 * @date 2020/2/12
 */
public class StandardLookupDemoBean implements DemoBean {
    private Singer mySinger;

    public void setMySinger(Singer mySinger) {
        this.mySinger = mySinger;
    }

    @Override
    public Singer getMySinger() {
        return mySinger;
    }

    @Override
    public void doSomething() {

    }
}
