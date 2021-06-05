package com.eplusing.prospring5.ch3.xml;

import com.eplusing.prospring5.ch3.annotation.Singer3;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;
import java.util.Map;

/**
 * @author eplusing
 * @date 2020/2/18
 */
public class DependOnDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        //ctx.load("classpath:spring/app-context-01.xml");
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();
        Singer3 singer = ctx.getBean("johnMayer", Singer3.class);
        singer.sing();
        ctx.close();
    }
}
