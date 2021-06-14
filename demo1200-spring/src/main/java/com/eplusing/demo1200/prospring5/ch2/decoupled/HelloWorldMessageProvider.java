package com.eplusing.demo1200.prospring5.ch2.decoupled;

/**
 * @author eplusing
 * @date 2019/12/29
 */
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
