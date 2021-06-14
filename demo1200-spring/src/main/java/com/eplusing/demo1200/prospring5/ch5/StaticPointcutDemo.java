package com.eplusing.demo1200.prospring5.ch5;

import com.eplusing.demo1200.prospring5.ch2.common.Singer;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author eplusing
 * @date 2020/3/22
 */
public class StaticPointcutDemo {
    public static void main(String[] args) {
        GoodGuitarist good = new GoodGuitarist();
        GreatGuitarist great = new GreatGuitarist();

        Singer goodProxy;
        Singer greatProxy;

        Pointcut pc = new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(good);
        goodProxy = (Singer) pf.getProxy();


        pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(great);
        greatProxy = (Singer) pf.getProxy();

        goodProxy.sing();
        greatProxy.sing();

    }
}
