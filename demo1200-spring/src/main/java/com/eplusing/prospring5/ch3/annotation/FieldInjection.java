package com.eplusing.prospring5.ch3.annotation;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author eplusing
 * @date 2020/1/5
 */
public class FieldInjection {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        ctx.refresh();

        Singer singerBean = ctx.getBean(Singer.class);
    }

}
