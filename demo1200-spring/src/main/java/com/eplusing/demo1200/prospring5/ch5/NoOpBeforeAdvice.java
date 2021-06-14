package com.eplusing.demo1200.prospring5.ch5;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author eplusing
 * @date 2020/3/23
 */
public class NoOpBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {

    }
}
