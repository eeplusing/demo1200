package com.eplusing.demo1200.activemq;

import org.springframework.stereotype.Component;

@Component
public class TopicConsumerListener
{
    //topic模式的消费者
    public void readActiveQueue(String message) {
        System.out.println("topic接受到：" + message);
    }
}