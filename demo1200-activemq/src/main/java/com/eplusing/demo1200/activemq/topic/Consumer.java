package com.eplusing.demo1200.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class Consumer {
    private  static String queue = "topic-message";

    public static void main(String[] args) throws JMSException, IOException {
        //第一步：创建ConnectionFactory对象，需要指定服务端ip及端口号。
        // brokerURL服务器的ip及端口号
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://192.168.145.136:61617");
        // 第二步：使用ConnectionFactory对象创建一个Connection对象。
        Connection connection = factory.createConnection();
        // 第三步：开启连接，调用Connection对象的start方法。
        connection.start();
        // 第四步：使用Connection对象创建一个Session对象。
        // 第一个参数：是否开启事务。true：开启事务，第二个参数忽略。
        // 第二个参数：当第一个参数为false时，才有意义。消息的应答模式。1、自动应答2、手动应答。
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        // 第五步：使用Session对象创建一个Destination对象。和发送端保持一致topic，并且话题的名称一致。
        Topic topic = session.createTopic(Consumer.queue);
        // 第六步：使用Session对象创建一个Consumer对象。
        MessageConsumer consumer = session.createConsumer(topic);

        //session.createDurableSubscriber(topic, "1111");

        // 第七步：接收消息。
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    // 取消息的内容
                    String text = textMessage.getText();
                    System.out.println(text);
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println("topic的消费端03。。。。。");
        // 等待键盘输入
        System.in.read();
        // 第九步：关闭资源
        consumer.close();
        session.close();
        connection.close();
    }
}
