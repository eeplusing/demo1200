package com.eplusing.demo1200.prospring5.ch4;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

/**
 * @author eplusing
 * @date 2020/2/23
 */
public class DestructiveBean implements InitializingBean {
    private File file;

    public void setFilePath(String filePath) {
        System.out.println(filePath);
        this.filePath = filePath;
    }

    private String filePath;
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean");
        if(filePath == null){
            throw new IllegalArgumentException(
                    "you must specify the filePath property of " + DestructiveBean.class
            );
        }
        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("File exists:" + file.exists());
    }

    public void destory(){
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

        DestructiveBean bean = (DestructiveBean) ctx.getBean("destructiveBean");
        System.out.println("Calling destory()");
        ctx.close();
        System.out.println("Called destory()");

    }


}
