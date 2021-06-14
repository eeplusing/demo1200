package com.eplusing.demo1200.prospring5.ch4.jsr330;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author eplusing
 * @date 2020/3/3
 */
public class Jsr330Demo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation-02.xml");
        ctx.refresh();

        MessageRenderer messageRenderer = ctx.getBean("messageRenderer", MessageRenderer.class);

        messageRenderer.render();
    }
}
