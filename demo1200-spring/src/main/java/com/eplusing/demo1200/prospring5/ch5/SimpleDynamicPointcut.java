package com.eplusing.demo1200.prospring5.ch5;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @author eplusing
 * @date 2020/3/22
 */
public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        System.out.println("Static check for " + method.getName());
        return "foo".equals(method.getName());
    }

    @Override
    public boolean matches(Method method, Class<?> aClass, Object... args) {
        System.out.println("Dyanmic check for " + method.getName());
        int x = ((Integer) args[0]).intValue();
        return x != 100;
    }

    @Override
    public ClassFilter getClassFilter() {
        return cls -> (cls == SampleBean.class);
    }
}
