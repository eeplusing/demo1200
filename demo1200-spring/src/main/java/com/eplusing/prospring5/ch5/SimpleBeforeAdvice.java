package com.eplusing.prospring5.ch5;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    public static void main(String[] args) {
        Guitarist johnMayer = new Guitarist();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(johnMayer);
        pf.addAdvice(new SimpleBeforeAdvice());

        Guitarist proxy = (Guitarist) pf.getProxy();

        proxy.sing();

    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before '" + method.getName() + "', tune guitar.");
    }
}
