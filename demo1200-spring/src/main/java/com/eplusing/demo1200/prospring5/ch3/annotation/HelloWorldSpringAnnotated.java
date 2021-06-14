package com.eplusing.demo1200.prospring5.ch3.annotation;

import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageRenderer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author eplusing
 * @date 2019/12/30
 */
public class HelloWorldSpringAnnotated {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
        ctx.close();
    }
}
