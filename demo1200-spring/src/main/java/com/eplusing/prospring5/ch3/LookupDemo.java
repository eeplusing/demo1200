package com.eplusing.prospring5.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * @author eplusing
 * @date 2020/2/12
 */
public class LookupDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        DemoBean abstractBean = ctx.getBean("abstractLookupBean", DemoBean.class);

        DemoBean standardBean = ctx.getBean("standardLookupBean", DemoBean.class);

        displayInfo("abstractLookupBean", abstractBean);
        displayInfo("standardLookupBean", standardBean);
    }

    private static void displayInfo(String beanName, DemoBean bean) {
        Singer s1 = bean.getMySinger();
        Singer s2 = bean.getMySinger();

        System.out.println(beanName + ": singer instance the same ? " + (s1 == s2));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for(int i = 0; i < 10000; i++){
            Singer singer = bean.getMySinger();
            singer.sing();
        }

        stopWatch.stop();
        System.out.println("10000 gets took " + stopWatch.getTotalTimeMillis() + "ms");
    }
}
