package com.eplusing.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;
import java.util.Map;

/**
 * @author eplusing
 * @date 2020/2/18
 */
public class BeanCrazyNaming {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-03.xml");
        ctx.refresh();
        Map<String, String> beans = ctx.getBeansOfType(String.class);
        beans.entrySet().stream().forEach(
                b -> System.out.println("id:" + b.getKey() +
                        "\n aliases:" + Arrays.toString(ctx.getAliases(b.getKey())) + "\n")
        );

        ctx.close();
    }
}
