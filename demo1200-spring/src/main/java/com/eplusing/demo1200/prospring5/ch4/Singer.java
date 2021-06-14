package com.eplusing.demo1200.prospring5.ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author eplusing
 * @date 2020/2/19
 */
public class Singer {
    public static final String DEFAULT_NAME = "Eric Claton";

    private String name;
    private int age = Integer.MAX_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public void init(){
        System.out.println("initializing bean");
        if(name == null){
            System.out.println("using default name");
            name = DEFAULT_NAME;
        }

        if(age == Integer.MAX_VALUE){
            throw new IllegalArgumentException("you must set the age property of any beans of type " + Singer.class);
        }
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
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);

        ctx.close();

    }

    private static Singer getBean(String beanName, ApplicationContext ctx) {
        try {
            Singer bean = (Singer)ctx.getBean(beanName);
            System.out.println(bean);
            return  bean;

        } catch (BeanCreationException ex){
            System.out.println("An error occured in bean configuration:" + ex.getMessage());
            return null;
        }

    }
}
