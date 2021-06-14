package com.eplusing.demo1200.prospring5.ch4.jsr330;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author eplusing
 * @date 2020/3/1
 */
@Named("messageProvider")
public class ConfigurableMessageProvider implements MessageProvider {
    private String message = "Default message";

    public ConfigurableMessageProvider() {
    }

    @Inject
    @Named("message")
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
