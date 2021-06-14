package com.eplusing.demo1200.prospring5.ch5;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class AgentDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("Cao ");
        Object retVal = methodInvocation.proceed();
        System.out.print("!");
        return retVal;
    }
}
