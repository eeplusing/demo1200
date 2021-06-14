package com.eplusing.demo1200.prospring5.ch4;

import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageProvider;
import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageRenderer;
import com.eplusing.demo1200.prospring5.ch2.decoupled.StandardOutMessageRenderer;
import com.eplusing.demo1200.prospring5.ch3.xml.ConfigurableMessageProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author eplusing
 * @date 2020/3/1
 */
public class JavaConfigExampleOne {
    @Configuration
    static class AppConfigOne {
        @Bean
        public MessageProvider messageProvider() {
            return new ConfigurableMessageProvider();
        }

        @Bean
        public MessageRenderer messageRenderer() {
            MessageRenderer render = new StandardOutMessageRenderer();
            render.setMessageProvider(messageProvider());
            return render;
        }


    }

    public static void main(String[] args) {
        //ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigOne.class);
        ApplicationContext ctx = new AnnotationConfigApplicationContext(com.eplusing.demo1200.prospring5.ch4.AppConfigOne.class);

        MessageRenderer renderer = ctx.getBean("messageRenderer", MessageRenderer.class);
        renderer.render();


    }
}
