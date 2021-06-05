package com.eplusing.prospring5.ch3.xml;

import com.eplusing.prospring5.ch2.decoupled.MessageProvider;

/**
 * @author eplusing
 * @date 2020/1/5
 */
public class ConfigurableMessageProvider implements MessageProvider {

    private String message = "Default message";

    public ConfigurableMessageProvider() {

    }


    //@Autowired
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {

        return this.getClass().getName() + "####" + message;
    }
}
