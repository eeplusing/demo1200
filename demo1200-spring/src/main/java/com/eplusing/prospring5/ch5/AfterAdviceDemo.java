package com.eplusing.prospring5.ch5;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author eplusing
 * @date 2020/3/21
 */
public class AfterAdviceDemo {
    public static void main(String[] args) {
        KeyGenerator keyGenerator = getKeyGenerator();
        for (int x = 0; x < 10; x++) {
            try {
                long key = keyGenerator.getKey();
                System.out.println("Key:" + key);
            } catch (SecurityException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static KeyGenerator getKeyGenerator() {
        KeyGenerator target = new KeyGenerator();
        ProxyFactory pf = new ProxyFactory(target);
        pf.addAdvice(new WeakCheckAdvice());
        return (KeyGenerator) pf.getProxy();
    }

}
