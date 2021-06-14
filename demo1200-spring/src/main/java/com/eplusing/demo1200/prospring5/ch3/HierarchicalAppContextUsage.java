package com.eplusing.demo1200.prospring5.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author eplusing
 * @date 2020/1/7
 */
public class HierarchicalAppContextUsage {
    public static void main(String[] args) {
        GenericXmlApplicationContext parentCtx = new GenericXmlApplicationContext();
        parentCtx.load("classpath:spring/parent-context.xml");
        parentCtx.refresh();

        GenericXmlApplicationContext childCtx = new GenericXmlApplicationContext();
        childCtx.load("classpath:spring/child-context.xml");
        childCtx.setParent(parentCtx);
        childCtx.refresh();

        Song s1 = (Song) childCtx.getBean("song1");
        Song s2 = (Song) childCtx.getBean("song2");
        Song s3 = (Song) childCtx.getBean("song3");

        System.out.println("from parent ctx:" + s1.getTitle());
        System.out.println("from child ctx:" + s2.getTitle());
        System.out.println("from parent ctx:" + s3.getTitle());

        parentCtx.close();
        childCtx.close();


    }
}
