package com.eplusing.prospring5.ch2.decoupled;

import java.io.IOException;
import java.util.Properties;

/**
 * @author eplusing
 * @date 2019/12/29
 */
public class MessageSupportFactory {
    private static MessageSupportFactory instance;
    private Properties props;
    private MessageProvider provider;
    private MessageRenderer renderer;

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance(){
        return instance;
    }

    private MessageSupportFactory(){
        props = new Properties();

        try {
            props.load(this.getClass().getResourceAsStream("/msf.properties"));
            String rendererClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");

            renderer = (MessageRenderer) Class.forName(rendererClass).newInstance();
            provider = (MessageProvider)Class.forName(providerClass).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public MessageRenderer getMessageRenderer(){
        return renderer;
    }

    public MessageProvider getMessageProvider(){
        return provider;
    }

}
