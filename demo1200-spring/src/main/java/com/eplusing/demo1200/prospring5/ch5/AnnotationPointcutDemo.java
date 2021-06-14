package com.eplusing.demo1200.prospring5.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

/**
 * @author eplusing
 * @date 2020/3/22
 */
public class AnnotationPointcutDemo {
    public static void main(String[] args) {
        Guitarist2 guitarist = new Guitarist2();

        AnnotationMatchingPointcut pc = AnnotationMatchingPointcut.forMethodAnnotation(AdviceRequired.class);

        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(guitarist);
        pf.addAdvisor(advisor);

        Guitarist2 guitaristProxy = (Guitarist2) pf.getProxy();
        guitaristProxy.sing();
        guitaristProxy.sing2();
        guitaristProxy.rest();

    }
}
