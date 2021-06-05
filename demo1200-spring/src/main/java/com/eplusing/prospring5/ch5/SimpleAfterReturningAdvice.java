package com.eplusing.prospring5.ch5;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class SimpleAfterReturningAdvice implements AfterReturningAdvice {
    public static void main(String[] args) {
        Guitarist johnMayer = new Guitarist();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(johnMayer);
        pf.addAdvice(new SimpleAfterReturningAdvice());

        Guitarist proxy = (Guitarist) pf.getProxy();

        proxy.sing();

    }


    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object target) throws Throwable {
        System.out.println("After '" + method.getName() + "' put down guitar.");
    }
}
