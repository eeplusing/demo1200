package com.eplusing.demo1200.prospring5.ch3;

import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageRenderer;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author eplusing
 * @date 2019/12/31
 */
public class DeclareSpringComponents {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        //ctx.load("classpath:spring/app-context-xml.xml");
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();


        ctx.close();

    }
}
