package com.eplusing.demo1200.prospring5.ch2.decoupled;

/**
 * @author eplusing
 * @date 2019/12/29
 */
public class HelloWorldDecoupled {
    public static void main(String[] args) {
        MessageRenderer mr = new StandardOutMessageRenderer();
        MessageProvider messageProvider = new HelloWorldMessageProvider();
        mr.setMessageProvider(messageProvider);
        mr.render();
    }
}
