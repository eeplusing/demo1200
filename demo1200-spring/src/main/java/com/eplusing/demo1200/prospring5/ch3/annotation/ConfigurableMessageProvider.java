package com.eplusing.demo1200.prospring5.ch3.annotation;

import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eplusing
 * @date 2020/1/5
 */
@Service("provider")
public class ConfigurableMessageProvider implements MessageProvider {

    private String message;

    @Autowired
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.getClass().getName() + "####" + message;
    }
}
