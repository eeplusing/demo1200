package com.eplusing.demo1200.prospring5.ch4;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author eplusing
 * @date 2020/2/29
 */
public class Publisher implements ApplicationContextAware {
    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public void publish(String message) {
        ctx.publishEvent(new MessageEvent(this, message));
    }

    public static void main(String[] args) {
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("classpath:spring/app-context-xml.xml");
        Publisher pub = (Publisher) ctx.getBean("publisher");
        pub.publish("I send an sos to the world");
        pub.publish("... My home");
        pub.publish("... Message in a bottle");


    }
}
