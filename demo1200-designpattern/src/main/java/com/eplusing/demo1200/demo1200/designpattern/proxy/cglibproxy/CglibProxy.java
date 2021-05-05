package com.eplusing.demo1200.demo1200.designpattern.proxy.cglibproxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("��Ʊ");
        return methodProxy.invokeSuper(o,objects);
    }

    public Object CreateProxyObject(Class<?> clazz){
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();

    }
}
