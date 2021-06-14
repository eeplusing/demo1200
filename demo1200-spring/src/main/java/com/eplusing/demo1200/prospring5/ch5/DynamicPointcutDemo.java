package com.eplusing.demo1200.prospring5.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author eplusing
 * @date 2020/3/22
 */
public class DynamicPointcutDemo {
    public static void main(String[] args) {
        SampleBean target = new SampleBean();


        Advisor advisor = new DefaultPointcutAdvisor(new SimpleDynamicPointcut(),
                new SimpleAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(target);
        SampleBean beanProxy = (SampleBean) pf.getProxy();

        beanProxy.foo(1);
        beanProxy.foo(100);
        beanProxy.foo(200);

        beanProxy.bar();
        beanProxy.bar();
        beanProxy.bar();

    }
}
