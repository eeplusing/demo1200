package com.eplusing.demo1200.prospring5.ch5;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author eplusing
 * @date 2020/3/22
 */
public class SimpleAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Invoking " + methodInvocation.getMethod().getName());
        Object retVal = methodInvocation.proceed();
        System.out.println("Done");
        return retVal;
    }
}
