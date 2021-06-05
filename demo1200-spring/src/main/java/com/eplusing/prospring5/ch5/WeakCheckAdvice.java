package com.eplusing.prospring5.ch5;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

import static com.eplusing.prospring5.ch5.KeyGenerator.WEAK_KEY;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class WeakCheckAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] objects, Object target) throws Throwable {
        if (target instanceof KeyGenerator && "getKey".equals(method.getName())) {
            long key = ((Long) returnValue).longValue();

            if (key == WEAK_KEY) {
                throw new SecurityException("Key Generator generated a weak key. Try again!");
            }
        }
    }
}
