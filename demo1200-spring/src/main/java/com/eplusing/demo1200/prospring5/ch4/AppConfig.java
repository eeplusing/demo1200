package com.eplusing.demo1200.prospring5.ch4;

import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageProvider;
import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageRenderer;
import com.eplusing.demo1200.prospring5.ch2.decoupled.StandardOutMessageRenderer;
import com.eplusing.demo1200.prospring5.ch3.xml.ConfigurableMessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author eplusing
 * @date 2020/3/1
 */
@Configuration
public class AppConfig {
    @Bean
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider();
    }

    @Bean
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(messageProvider());
        return renderer;
    }
}
