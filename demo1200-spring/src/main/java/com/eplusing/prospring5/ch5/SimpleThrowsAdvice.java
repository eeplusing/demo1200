package com.eplusing.prospring5.ch5;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author eplusing
 * @date 2020/3/22
 */
public class SimpleThrowsAdvice implements ThrowsAdvice {
    public static void main(String[] args) {
        ErrorBean errorBean = new ErrorBean();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(errorBean);
        pf.addAdvice(new SimpleThrowsAdvice());

        ErrorBean proxy = (ErrorBean) pf.getProxy();
        try {
            proxy.errorProneMethod();
        } catch (Exception e) {

        }

        try {
            proxy.otherErrorException();
        } catch (Exception e) {

        }


    }

    public void afterThrowing(Exception ex) throws Throwable {
        System.out.println("Generic Exception Capture");
        System.out.println("Caught:" + ex.getClass().getName());
    }


    public void afterThrowing(Method method, Objects args, Object target, IllegalArgumentException ex) {
        System.out.println("IllegalArgumentsException Capture");
        System.out.println("Caught:" + ex.getClass().getName());
        System.out.println("Method:" + method.getName());

    }

}
