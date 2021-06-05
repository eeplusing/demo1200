package com.eplusing.prospring5.ch3.xml;

import com.eplusing.prospring5.ch3.Oracle;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author eplusing
 * @date 2020/1/7
 */
public class InjectRef {
    private Oracle oracle;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();
        InjectRef injectref = (InjectRef) ctx.getBean("injectRef");
        System.out.println(injectref);

        ctx.close();



    }
    public void setOracle(Oracle oracle) {
        this.oracle=oracle;
    }

    @Override
    public String toString() {
        return oracle.defineMeaningOfLife();
    }
}
