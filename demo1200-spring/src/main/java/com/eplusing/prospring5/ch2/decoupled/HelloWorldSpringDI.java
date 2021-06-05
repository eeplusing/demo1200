package com.eplusing.prospring5.ch2.decoupled;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author eplusing
 * @date 2019/12/29
 */
public class HelloWorldSpringDI {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/app-context-xml.xml");
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);

        mr.render();
    }
}
