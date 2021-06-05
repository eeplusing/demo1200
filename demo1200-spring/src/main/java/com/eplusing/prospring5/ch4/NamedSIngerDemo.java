package com.eplusing.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.inject.Named;

/**
 * @author eplusing
 * @date 2020/2/23
 */
public class NamedSIngerDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        NamedSinger bean = (NamedSinger) ctx.getBean("johnMayer");
        bean.sing();

        ctx.close();
    }
}
