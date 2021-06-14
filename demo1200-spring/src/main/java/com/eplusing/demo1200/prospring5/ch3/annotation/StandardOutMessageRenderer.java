package com.eplusing.demo1200.prospring5.ch3.annotation;

import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageProvider;
import com.eplusing.demo1200.prospring5.ch2.decoupled.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author eplusing
 * @date 2019/12/29
 */
@Service("renderer")
public class StandardOutMessageRenderer implements MessageRenderer {

    private MessageProvider messageProvider;

    @Override
    public void render() {
        if (messageProvider == null) {
            throw new RuntimeException("you must set thie property messageProvider" +
                    " of class " +
                    StandardOutMessageRenderer.class.getName());
        }

        System.out.println(messageProvider.getMessage());
    }

    @Autowired
    @Override
    public void setMessageProvider(MessageProvider messageProvider) {
        this.messageProvider = messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return this.messageProvider;
    }
}
