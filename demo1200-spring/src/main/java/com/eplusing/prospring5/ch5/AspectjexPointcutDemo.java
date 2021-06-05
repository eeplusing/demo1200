package com.eplusing.prospring5.ch5;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @author eplusing
 * @date 2020/3/22
 */
public class AspectjexPointcutDemo {
    public static void main(String[] args) {
        Guitarist guitarist = new Guitarist();

        AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
        pc.setExpression("execution(* sing*(..))");
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
