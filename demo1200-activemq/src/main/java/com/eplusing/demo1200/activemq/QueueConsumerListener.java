package com.eplusing.demo1200.activemq;

import org.springframework.stereotype.Component;
@Component
public class QueueConsumerListener
{
    //queue模式的消费者
    public void readActiveQueue(String message) {
        System.out.println("queue接受到：" + message);
    }
}
