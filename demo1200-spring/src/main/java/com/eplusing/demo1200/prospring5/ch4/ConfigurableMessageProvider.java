package com.eplusing.demo1200.prospring5.ch4;

import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author eplusing
 * @date 2020/3/1
 */
@Service
public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    public ConfigurableMessageProvider() {
    }

    public ConfigurableMessageProvider(@Value("Love on the weekend") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
