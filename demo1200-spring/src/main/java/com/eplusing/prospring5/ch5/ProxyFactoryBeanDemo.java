package com.eplusing.prospring5.ch5;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author eplusing
 * @date 2020/4/19
 */
public class ProxyFactoryBeanDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("spring/app-context-xml.xml");
        ctx.refresh();

        Documentarist documentaristOne = ctx.getBean("documentsristOne", Documentarist.class);
        Documentarist documentaristTwo = ctx.getBean("documentaristTwo", Documentarist.class);

        System.out.println("documentaristOne execute");
        documentaristOne.execute();
        System.out.println("documentaristTwo execute");
        documentaristTwo.execute();

    }
}
