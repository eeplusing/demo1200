package com.eplusing.prospring5.ch4;

import org.springframework.context.ApplicationListener;

/**
 * @author eplusing
 * @date 2020/2/29
 */
public class MessageEventListener implements ApplicationListener<MessageEvent> {
    @Override
    public void onApplicationEvent(MessageEvent messageEvent) {
        MessageEvent msgEvt = messageEvent;
        System.out.println("Receievd:" + msgEvt.getMsg());
    }

}
