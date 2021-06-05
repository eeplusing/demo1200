package com.eplusing.prospring5.ch2.decoupled;

/**
 * @author eplusing
 * @date 2019/12/29
 */
public interface MessageRenderer {
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvider();
}
