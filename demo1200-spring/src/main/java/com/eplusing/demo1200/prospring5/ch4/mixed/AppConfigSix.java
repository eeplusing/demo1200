package com.eplusing.demo1200.prospring5.ch4.mixed;

import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageProvider;
import com.eplusing.demo1200.prospring5.ch4.annotated.ConfigurableMessageProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author eplusing
 * @date 2020/3/1
 */
@Configuration
public class AppConfigSix {
    @Bean
    public MessageProvider provider() {
        return new ConfigurableMessageProvider("Love the weekend");
    }
}
