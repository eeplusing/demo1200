package com.eplusing.prospring5.ch5;

import org.springframework.aop.support.StaticMethodMatcher;

import java.lang.reflect.Method;

/**
 * @author eplusing
 * @date 2020/3/24
 */
public class SingMethodMatcher extends StaticMethodMatcher {
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return method.getName().startsWith("si");
    }
}
