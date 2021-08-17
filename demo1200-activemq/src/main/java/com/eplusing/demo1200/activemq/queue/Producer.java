package com.eplusing.demo1200.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Producer {
    private  static String queue = "queue message";
    public static void main(String[] args) throws JMSException {
        // 第一步：创建ConnectionFactory对象，需要指定服务端ip及端口号。
        //brokerURL服务器的ip及端口号
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.145.136:61617");
        // 第二步：使用ConnectionFactory对象创建一个Connection对象。
        Connection connection = factory.createConnection();
        // 第三步：开启连接，调用Connection对象的start方法。
        connection.start();
        // 第四步：使用Connection对象创建一个Session对象。
        //第一个参数：是否开启事务。true：开启事务，第二个参数忽略。
        //第二个参数：当第一个参数为false时，才有意义。消息的应答模式。1、自动应答2、手动应答。
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 第五步：使用Session对象创建一个Destination对象（topic、queue），此处创建一个Queue对象。
        //参数：队列的名称。
        Destination destination = session.createQueue(queue);
        // 第六步：使用Session对象创建一个Producer对象。
        MessageProducer producer = session.createProducer(destination);
        for (int i=0;i<10;i++) {
            // 第七步：创建一个Message对象，创建一个TextMessage对象。
            TextMessage textMessage = session.createTextMessage("消费者你好我来了" + i);
            // 第八步：使用Producer对象发送消息。
            producer.send(textMessage);
        }
        System.out.println("生产结束");
        // 第九步：关闭资源。
        producer.close();
        session.close();
        connection.close();
    }
}
