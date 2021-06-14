package com.eplusing.demo1200.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author eplusing
 * @date 2020/2/23
 */
public class MessageDigestFactoryDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        MessageDigester digester = ctx.getBean("digester2", MessageDigester.class);
        digester.digest("hello world");

        ctx.close();
    }
}
