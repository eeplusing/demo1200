package com.eplusing.demo1200.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.security.MessageDigest;

/**
 * @author eplusing
 * @date 2020/2/23
 */
public class AccessingFactoryBeans {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();
        ctx.getBean("shaDigest", MessageDigest.class);
        MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) ctx.getBean("&shaDigest");

        try {
            MessageDigest shaDigest = factoryBean.getObject();
            System.out.println(shaDigest.digest("hello world".getBytes()));
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
