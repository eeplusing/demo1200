package com.eplusing.prospring5.ch5;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author eplusing
 * @date 2020/3/23
 */
public class TestPointcut extends StaticMethodMatcherPointcut {

    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return "advised".equals(method.getName());
    }
}
