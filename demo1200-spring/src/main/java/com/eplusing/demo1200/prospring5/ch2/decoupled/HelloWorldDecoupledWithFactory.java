package com.eplusing.demo1200.prospring5.ch2.decoupled;

/**
 * @author eplusing
 * @date 2019/12/29
 */
public class HelloWorldDecoupledWithFactory {
    public static void main(String[] args) {
        MessageRenderer mr = MessageSupportFactory.getInstance().getMessageRenderer();
        MessageProvider messageProvider = MessageSupportFactory.getInstance().getMessageProvider();

        mr.setMessageProvider(messageProvider);
        mr.render();
    }
}
