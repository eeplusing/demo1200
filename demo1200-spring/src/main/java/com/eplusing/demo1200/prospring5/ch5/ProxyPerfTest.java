package com.eplusing.demo1200.prospring5.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author eplusing
 * @date 2020/3/23
 */
public class ProxyPerfTest {
    public static void main(String[] args) {
        SimpleBean target = new DefaultSimpleBean();
        Advisor advisor = new DefaultPointcutAdvisor(new TestPointcut(), new NoOpBeforeAdvice());

        runCglibTests(advisor, target);

        runCglibFrozenTests(advisor, target);

        runJdkTests(advisor, target);
    }

    private static void runCglibTests(Advisor advisor, SimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setProxyTargetClass(true);
        pf.setTarget(target);
        pf.addAdvisor(advisor);

        SimpleBean bean = (SimpleBean) pf.getProxy();
        System.out.println("Running CGLIB(Standard) Tests");
        test(bean);

    }


    private static void runCglibFrozenTests(Advisor advisor, SimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setProxyTargetClass(true);
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setFrozen(true);

        SimpleBean bean = (SimpleBean) pf.getProxy();
        System.out.println("Running CGLIB(Frozen) Tests");
        test(bean);
    }

    private static void runJdkTests(Advisor advisor, SimpleBean target) {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisor(advisor);
        pf.setInterfaces(new Class[]{
                SimpleBean.class
        });


        SimpleBean bean = (SimpleBean) pf.getProxy();
        System.out.println("Running JDK Tests");
        test(bean);
    }

    private static void test(SimpleBean bean) {
        long before = 0;
        long after = 0;

        System.out.println("Testing Advised Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 50000; x++) {
            bean.advised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + "ms");

        System.out.println("Testing unAdvised Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 50000; x++) {
            bean.unadvised();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + "ms");

        System.out.println("Testing equals Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 50000; x++) {
            bean.equals(bean);
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + "ms");

        System.out.println("Testing hashCode() Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 50000; x++) {
            bean.hashCode();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + "ms");

        System.out.println("Testing Advised.getProxyTargetClass() Method");
        before = System.currentTimeMillis();
        for (int x = 0; x < 50000; x++) {
            ((Advised) bean).getTargetClass();
        }
        after = System.currentTimeMillis();
        System.out.println("Took " + (after - before) + "ms");

    }
}
