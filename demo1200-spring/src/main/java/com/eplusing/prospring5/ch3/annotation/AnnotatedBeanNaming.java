package com.eplusing.prospring5.ch3.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.rmi.activation.ActivationSystem;
import java.util.Arrays;
import java.util.Map;

/**
 * @author eplusing
 * @date 2020/2/18
 */
public class AnnotatedBeanNaming {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        Map<String, Singer1> beans = ctx.getBeansOfType(Singer1.class);
        beans.entrySet().stream().forEach(
                b -> System.out.println( b.getKey())
        );

        ctx.close();
    }
}
