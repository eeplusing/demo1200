package com.eplusing.demo1200.prospring5.ch4.config;

import com.eplusing.demo1200.prospring5.ch4.Singer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

/**
 * @author eplusing
 * @date 2020/2/23
 */
public class SingerConfigDemo {

    static class SingerConfig{
        @Lazy
        @Bean(initMethod = "init")
        Singer singerOne(){
            Singer singerOne = new Singer();
            singerOne.setAge(39);
            singerOne.setName("John Mayer");
            return singerOne;
        }

        @Lazy
        @Bean(initMethod = "init")
        Singer singerTwo(){
            Singer singerTwo = new Singer();
            singerTwo.setAge(18);
            return singerTwo;
        }

        @Lazy
        @Bean(initMethod = "init")
        Singer singerThree(){
            Singer singerThree = new Singer();
            singerThree.setName("John petter");
            return singerThree;
        }

    }

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(SingerConfig.class);
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
