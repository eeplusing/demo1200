package com.eplusing.demo1200.prospring5.ch3.sandbox;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author eplusing
 * @date 2020/2/18
 */

@Component("gigi")
@Lazy
public class TrickyTarget {
    Foo fooOne;
    Foo fooTwo;
    Bar bar;

    public TrickyTarget(){
        System.out.println("Target.constructor()");
    }

    public TrickyTarget(Foo foo) {
        System.out.println("Target(Foo) called");
    }

    public TrickyTarget(Foo foo, Bar bar) {
        System.out.println("Target(Foo, Bar) called");
    }

    @Autowired
    @Qualifier("fooImplOne")
    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        System.out.println("Property fooOne set");
    }

    @Autowired
    @Qualifier("fooImplTwo")
    public void setFooTwo(Foo fooTwo) {
        this.fooTwo = fooTwo;
        System.out.println("Property fooTwo set");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("Property bar set");
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-04.xml");
        ctx.refresh();

        TrickyTarget t = null;

        t =  ctx.getBean(TrickyTarget.class);



        ctx.close();

    }
}
