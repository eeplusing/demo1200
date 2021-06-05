package com.eplusing.prospring5.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;

/**
 * @author eplusing
 * @date 2020/3/22
 */
public class RegexPointcutDemo {
    public static void main(String[] args) {
        Guitarist guitarist = new Guitarist();

        JdkRegexpMethodPointcut pc = new JdkRegexpMethodPointcut();
        pc.setPattern(".*sing.*");
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(guitarist);
        pf.addAdvisor(advisor);

        Guitarist guitaristProxy = (Guitarist) pf.getProxy();
        guitaristProxy.sing();
        guitaristProxy.sing2();
        guitaristProxy.rest();

    }
}
