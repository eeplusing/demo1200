package com.eplusing.demo1200.prospring5.ch5;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class AgentAOPDemo {
    public static void main(String[] args) {
        Agent target = new Agent();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new AgentDecorator());
        pf.setTarget(target);

        Agent proxy = (Agent) pf.getProxy();

        target.speak();
        System.out.println("");

        proxy.speak();
    }

    public void speak() {
        System.out.println("xuanxuan");
    }
}
