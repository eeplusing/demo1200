package com.eplusing.demo1200.prospring5.ch4;

import org.springframework.context.ApplicationEvent;

/**
 * @author eplusing
 * @date 2020/2/29
 */
public class MessageEvent extends ApplicationEvent {
    private String msg;

    public MessageEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
