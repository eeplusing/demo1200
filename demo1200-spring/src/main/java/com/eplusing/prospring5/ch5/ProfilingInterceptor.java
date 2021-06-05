package com.eplusing.prospring5.ch5;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(methodInvocation.getMethod().getName());

        Object returnValue = methodInvocation.proceed();

        sw.stop();
        dumpInfo(methodInvocation, sw.getTotalTimeMillis());


        return returnValue;
    }

    private void dumpInfo(MethodInvocation methodInvocation, long totalTimeMillis) {
        Method m = methodInvocation.getMethod();
        Object target = methodInvocation.getThis();
        Object[] argrs = methodInvocation.getArguments();

        System.out.println("Executed method: " + m.getName());
        System.out.println("On object of type:" + target.getClass().getName());

        System.out.println("With arguments: ");
        for (int x = 0; x < argrs.length; x++) {
            System.out.println(" > " + argrs[x]);
        }
        System.out.println("\n");

        System.out.println("Took: " + totalTimeMillis + "ms");
    }
}
