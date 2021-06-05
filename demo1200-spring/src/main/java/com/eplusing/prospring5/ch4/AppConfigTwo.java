package com.eplusing.prospring5.ch4;

import com.eplusing.prospring5.ch2.decoupled.MessageProvider;
import com.eplusing.prospring5.ch2.decoupled.MessageRenderer;
import com.eplusing.prospring5.ch2.decoupled.StandardOutMessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author eplusing
 * @date 2020/3/1
 */
@Configuration
@ComponentScan(basePackages = "com.eplusing.prospring5.ch4.annotated")
public class AppConfigTwo {
    @Autowired
    MessageProvider provider;

    @Bean(name = "messageRenderer")
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider);
        return renderer;
    }
}
