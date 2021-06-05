package com.eplusing.prospring5.ch3.annotation;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author eplusing
 * @date 2020/2/18
 */
public class NonSingletonDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        //ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        Singer2 s1 = ctx.getBean("nonSingleton", Singer2.class);
        Singer2 s2 = ctx.getBean("nonSingleton", Singer2.class);

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println(s1);
        System.out.println(s2);

        ctx.close();
    }
}
