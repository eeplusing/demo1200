package com.eplusing.demo1200.prospring5.ch4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.File;

/**
 * @author eplusing
 * @date 2020/2/29
 */
public class ResourceDemo {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext();

        File file = File.createTempFile("test", "txt");
        file.deleteOnExit();


        Resource res1 = ctx.getResource("file://" + file.getPath());
        displayInfo(res1);
        Resource res2 = ctx.getResource("classpath:test.txt");
        displayInfo(res2);
        Resource res3 = ctx.getResource("https://translate.google.cn/#view=home&op=translate&sl=en&tl=zh-CN&text=resolvable");
        displayInfo(res3);


    }

    private static void displayInfo(Resource res) throws Exception {
        System.out.println(res.getClass());
        System.out.println(res.getURL().getContent());
        System.out.println("");
    }
}
