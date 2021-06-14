package com.eplusing.demo1200.prospring5.ch3.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author eplusing
 * @date 2020/1/5
 */
public class ConstructorConfusion {
    private String someValue;

    public ConstructorConfusion(String someValue) {
        System.out.println("ConstructorConfusion(String) called");
        this.someValue = someValue;
    }

    @Autowired
    public ConstructorConfusion(@Value("100") int someValue) {
        System.out.println("ConstructorConfusion(int) called");
        this.someValue = "Number:" + Integer.toString(someValue);
    }

    @Override
    public String toString() {
        return someValue;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        ConstructorConfusion cc = ctx.getBean("constructorConfusion", ConstructorConfusion.class);

        System.out.println(cc);

        ctx.close();



    }
}
