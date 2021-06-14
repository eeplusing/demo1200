package com.eplusing.demo1200.prospring5.ch4.jsr330;

/**
 * @author eplusing
 * @date 2020/3/3
 */
public interface MessageRenderer {
    void render();

    void setMessageProvider(MessageProvider messageProvider);

    MessageProvider getMessageProvider();
}
