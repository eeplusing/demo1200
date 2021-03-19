package com.eplusing.designpattern.proxy.jdkproxy;

/**
 * JDK动态代理的秘密也就这些，简单一句话，
 * 动态代理就是要生成一个包装类对象，由于代理的对象是动态的，所以叫动态代理。
 * 由于我们需要增强，这个增强是需要留给开发人员开发代码的，因此代理类不能直接包含被代理对象，
 * 而是一个InvocationHandler，该InvocationHandler包含被代理对象，
 * 并负责分发请求给被代理对象，分发前后均可以做增强。从原理可以看出，JDK动态代理是“对象”的代理。
 *
 * **/


public class JdkProxyTest {
    public static void main(String[] args) {
        LiuDehua liuDehua = new LiuDehua();

        System.out.println(liuDehua.dance(""));
        System.out.println(liuDehua.sing(""));

        StarProxy startProxy = new StarProxy();
        startProxy.setTarget(liuDehua);

        Object liudeihuaProxy = startProxy.createProxyObject();

        Star star = (Star) liudeihuaProxy;
        System.out.println(star.sing(""));
        System.out.println(star.dance(""));


    }
}
