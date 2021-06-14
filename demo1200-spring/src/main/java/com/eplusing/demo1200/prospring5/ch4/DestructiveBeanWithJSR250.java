package com.eplusing.demo1200.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

/**
 * @author eplusing
 * @date 2020/2/23
 */
public class DestructiveBeanWithJSR250 {
    private File file;

    public void setFilePath(String filePath) {
        System.out.println(filePath);
        this.filePath = filePath;
    }

    private String filePath;
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean");
        if(filePath == null){
            throw new IllegalArgumentException(
                    "you must specify the filePath property of " + DestructiveBeanWithJSR250.class
            );
        }
        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("File exists:" + file.exists());
    }

    @PreDestroy
    public void destroy() throws Exception {
        System.out.println("Destorying Bean");
        if(!file.delete()){
            System.out.println("ERROR: failed to delete file");
        }
        System.out.println("File exists:" + file.exists());
    }


    public static void main(String[] args){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        DestructiveBeanWithJSR250 bean = (DestructiveBeanWithJSR250)
                ctx.getBean("destructiveBeanWithJSR250");
        System.out.println("Calling destory()");
        ctx.close();
        System.out.println("Called destory()");

    }




}
