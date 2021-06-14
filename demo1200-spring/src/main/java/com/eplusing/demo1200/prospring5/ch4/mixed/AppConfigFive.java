package com.eplusing.demo1200.prospring5.ch4.mixed;

import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageProvider;
import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageRenderer;
import com.eplusing.demo1200.prospring5.ch2.decoupled.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @author eplusing
 * @date 2020/3/1
 */
@Configuration
@ImportResource(value = "classpath:spring/app-context-xml-01.xml")
public class AppConfigFive {
    @Autowired
    MessageProvider provider;

    @Bean(name = "messageRenderer")
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider);
        return renderer;
    }
}
