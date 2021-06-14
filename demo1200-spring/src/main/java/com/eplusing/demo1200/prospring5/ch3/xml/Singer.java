package com.eplusing.demo1200.prospring5.ch3.xml;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author eplusing
 * @date 2020/2/18
 */
public class Singer implements ApplicationContextAware {
    ApplicationContext ctx;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    private Guitar guitar;

    public Singer(){

    }

    public void sing(){
        guitar = ctx.getBean("gopher", Guitar.class);
        guitar.sing();
    }
}
