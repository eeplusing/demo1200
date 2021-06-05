package com.eplusing.prospring5.ch3.xml.complicated;

import com.eplusing.prospring5.ch3.xml.Bar;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author eplusing
 * @date 2020/2/19
 */
public class CTarget {
    private Foo fooOne;
    private Foo fooTwo;
    private Bar bar;

    public CTarget(){}

    public CTarget(Foo foo) {
        System.out.println("Target(Foo) called");
    }

    public CTarget(Foo foo, Bar bar) {
        System.out.println("Target(Foo, Bar) called");
    }

    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        System.out.println("Property fooOne set");
        System.out.println(fooOne.sing());
    }

    public void setFooTwo(Foo fooTwo) {
        this.fooTwo = fooTwo;
        System.out.println("Property fooTwo set");
        System.out.println(fooTwo.sing());
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-04.xml");
        ctx.refresh();

        CTarget t = null;

        /*System.out.println("by name \n");
        t = (CTarget)ctx.getBean("targetByName");*/

        System.out.println("by type \n");
        t = (CTarget)ctx.getBean("targetByType");
        System.out.println();


        /*System.out.println("constructor \n");
        t = (CTarget)ctx.getBean("targetConstructor");*/

        ctx.close();

    }
}
