package com.eplusing.prospring5.ch5;

import com.eplusing.prospring5.ch2.common.Guitar;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author eplusing
 * @date 2020/3/24
 */
public class ComposablePoincutExample {
    public static void main(String[] args) {
        GammyGuitarist johnMayer = new GammyGuitarist();

        ComposablePointcut pc = new ComposablePointcut(ClassFilter.TRUE, new SingMethodMatcher());
        System.out.println("Test 1 >>");
        GammyGuitarist proxy = getProxy(pc, johnMayer);
        testInvoke(proxy);


        System.out.println("Test 2 >>");
        pc.union(new TalkMethodMatcher());
        proxy = getProxy(pc, johnMayer);

        testInvoke(proxy);

        System.out.println("Test 3 >>");
        pc.intersection(new RestMethodMatcher());
        proxy = getProxy(pc, johnMayer);
        testInvoke(proxy);


    }

    private static void testInvoke(GammyGuitarist proxy) {
        proxy.sing();
        proxy.sing(new Guitar());
        proxy.talk();
        proxy.rest();

    }

    private static GammyGuitarist getProxy(ComposablePointcut pc, GammyGuitarist johnMayer) {
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleBeforeAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(johnMayer);
        pf.addAdvisor(advisor);

        GammyGuitarist proxy = (GammyGuitarist) pf.getProxy();
        return proxy;


    }
}
