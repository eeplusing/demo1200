package com.eplusing.prospring5.ch5;


import org.aspectj.lang.JoinPoint;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author eplusing
 * @date 2020/4/19
 */
public class AuditAdvice implements MethodBeforeAdvice {
    public void simpleBeforeAdvice(JoinPoint joinPoint) {
        System.out.println("Executing:" + joinPoint.getSignature().getDeclaringType() + joinPoint.getSignature().getName());
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

    }
}
