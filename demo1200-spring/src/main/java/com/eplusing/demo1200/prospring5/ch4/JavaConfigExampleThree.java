package com.eplusing.demo1200.prospring5.ch4;

import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author eplusing
 * @date 2020/3/1
 */
public class JavaConfigExampleThree {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("classpath:spring/app-context-xml-02.xml");

        MessageRenderer messageRenderer = ctx.getBean("messageRenderder", MessageRenderer.class);
        messageRenderer.render();

    }
}
