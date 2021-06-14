package com.eplusing.demo1200.prospring5.ch4.annotated;

import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageProvider;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author eplusing
 * @date 2020/3/1
 */

public class ConfigurableMessageProvider implements MessageProvider {
    private String message;

    public ConfigurableMessageProvider(@Value("Love on the weekend") String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return null;
    }
}
