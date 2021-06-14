package com.eplusing.demo1200.prospring5.ch5;

import com.eplusing.demo1200.prospring5.ch2.common.Guitar;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;

/**
 * @author eplusing
 * @date 2020/3/22
 */
public class NamePointcutUsingAdvisorDemo {
    public static void main(String[] args) {
        GammyGuitarist gammyGuitarist = new GammyGuitarist();
/*
        NameMatchMethodPointcut pc = new NameMatchMethodPointcut();
        pc.addMethodName("sing");
        pc.addMethodName("rest");*/

        NameMatchMethodPointcutAdvisor advisor = new NameMatchMethodPointcutAdvisor(new SimpleAdvice());
        advisor.setMappedNames("rest", "sing");
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(gammyGuitarist);
        pf.addAdvisor(advisor);

        GammyGuitarist proxy = (GammyGuitarist) pf.getProxy();
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.rest();
        proxy.talk();

    }
}
