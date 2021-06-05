package com.eplusing.prospring5.ch4;

import com.eplusing.prospring5.ch2.decoupled.MessageProvider;
import com.eplusing.prospring5.ch2.decoupled.MessageRenderer;
import com.eplusing.prospring5.ch2.decoupled.StandardOutMessageRenderer;
import com.eplusing.prospring5.ch3.xml.ConfigurableMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

/**
 * @author eplusing
 * @date 2020/3/1
 */
@Configuration
@PropertySource(value = "classpath:message.properties")
public class AppConfigOne {
    @Autowired
    Environment env;

    @Bean
    @Lazy
    public MessageProvider messageProvider() {
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean(name = "messageRenderer")
    @Scope("prototype")
    @DependsOn(value = "messageProvider")
    public MessageRenderer messageRender() {
        MessageRenderer render = new StandardOutMessageRenderer();
        render.setMessageProvider(messageProvider());
        return render;
    }

    public static void main(String[] args) {

    }
}
