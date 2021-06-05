package com.eplusing.prospring5.ch3;

import org.junit.rules.Stopwatch;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * @author eplusing
 * @date 2020/2/16
 */
public class MethodReplacementDemo {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        ReplacementTarget replacementTarget = (ReplacementTarget)ctx.getBean("replacementTarget");
        ReplacementTarget standardTarget = (ReplacementTarget)ctx.getBean("standardTarget");

        displayInfo(replacementTarget);
        displayInfo(standardTarget);
    }

    private static void displayInfo(ReplacementTarget target) {
        System.out.println("test");

        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        for (int i = 0; i < 100000; i++) {
            String out = target.formatMessage("No filter");
        }

        stopWatch.stop();

        System.out.println("100000 invocations took: " + stopWatch.getTotalTimeMillis() + " ms");
    }


}
