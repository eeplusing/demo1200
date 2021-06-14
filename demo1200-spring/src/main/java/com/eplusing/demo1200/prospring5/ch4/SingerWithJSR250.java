package com.eplusing.demo1200.prospring5.ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

/**
 * @author eplusing
 * @date 2020/2/19
 */
public class SingerWithJSR250{
    public static final String DEFAULT_NAME = "Eric Claton";

    private String name;
    private int age = Integer.MAX_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Singer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);

        ctx.close();

    }

    private static SingerWithJSR250 getBean(String beanName, ApplicationContext ctx) {
        try {
            SingerWithJSR250 bean = (SingerWithJSR250)ctx.getBean(beanName);
            System.out.println(bean);
            return  bean;

        } catch (BeanCreationException ex){
            System.out.println("An error occured in bean configuration:" + ex.getMessage());
            return null;
        }

    }

    @PostConstruct
    public void init() throws Exception {
        System.out.println("initializing bean");
        if(name == null){
            System.out.println("using default name");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MAX_VALUE){
            throw new IllegalArgumentException("you must set the age property of any beans of type " + SingerWithJSR250.class);
        }
    }
}
