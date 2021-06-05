package com.eplusing.prospring5.ch3.xml;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author eplusing
 * @date 2020/2/19
 */
public class InheritanceDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        Student ps = (Student) ctx.getBean("parentStu");
        Student cs = (Student) ctx.getBean("childStu");

        System.out.println(ps);
        System.out.println(cs);

    }
}
