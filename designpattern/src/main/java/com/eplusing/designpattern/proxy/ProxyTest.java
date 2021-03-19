package com.eplusing.designpattern.proxy;

import java.util.Arrays;

public class ProxyTest {
    public static void main(String[] args) {
        LiuDehua liuDehua = new LiuDehua();

        System.out.println(liuDehua.dance(""));
        System.out.println(liuDehua.sing(""));

        StartProxy startProxy = new StartProxy();
        startProxy.setTarget(liuDehua);

        Object liudeihuaProxy = startProxy.createProxyObject();

        Star star = (Star) liudeihuaProxy;
        System.out.println(star.sing(""));
        System.out.println(star.dance(""));


    }
}
