package com.eplusing.demo1200.prospring5.ch4;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author eplusing
 * @date 2020/2/29
 */
public class CustomEditorExample {
    private FullName name;

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-config-02.xml");
        ctx.refresh();

        CustomEditorExample bean = (CustomEditorExample) ctx.getBean("exampleBean");

        System.out.println(bean.getName());

        ctx.close();
    }
}
