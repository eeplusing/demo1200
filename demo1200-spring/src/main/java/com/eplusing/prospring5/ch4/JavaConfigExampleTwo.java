package com.eplusing.prospring5.ch4;

import com.eplusing.prospring5.ch2.decoupled.MessageRenderer;
import com.eplusing.prospring5.ch4.mixed.AppConfigFive;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author eplusing
 * @date 2020/3/1
 */
public class JavaConfigExampleTwo {

    public static void main(String[] args) {
        //ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigTwo.class);
        //ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigThree.class);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigFive.class);

        MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();


    }
}
