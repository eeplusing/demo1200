package com.eplusing;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

/**
 * @author caopengpeng
 * @desciption
 * @date 2021/11/5 21:26
 **/
public class RabbitmqUtil {

    private static final Logger log = LoggerFactory.getLogger(RabbitmqUtil.class);
    private static TreeSet<Long> tags = new TreeSet<>();

    private RabbitmqUtil() {
    }

    public static void main(String[] args) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.20.99.5");
        factory.setPort(5672);
        factory.setUsername("momq");
        factory.setPassword("P@ss2345");
        factory.setConnectionTimeout(3000);
        factory.setVirtualHost("ttl-tap-vhost");
        Connection conn = null;
        try {
            conn = factory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

        String queueName = "settlement.oms.queue";
        String exchangeName = "";
        String routeKey = "caopengpeng.test.quene";

        Channel channel = null;
        try {
            channel = conn.createChannel();
            //channel.queueBind(queueName, exchangeName, routeKey);

            //or
            //channel.queueDeclare(queueName, true, false, false, null);

        } catch (IOException e) {
            log.error("获取rabbitmq连接异常：{}", e.getMessage());
        }

        AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder().deliveryMode(2).
                contentEncoding("UTF-8").build();
        String msg = "testExchange";

        log.info("生产的mq消息内容[" + msg + "]");

        try {
            channel.basicPublish(exchangeName, routeKey, properties, msg.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            channel.close();
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }


    public Connection getConn() {
        //创建一个新的连接
        Connection connection = null;
        try {

            // 创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("host");
            factory.setPort(8080);
            factory.setUsername("username");
            factory.setPassword("password");
            factory.setConnectionTimeout(3000);
            factory.setVirtualHost("vhost");
            connection = factory.newConnection();
        } catch (IOException e) {
            log.error("获取rabbitmq连接异常：{}", e.getMessage());
        } catch (TimeoutException e) {
            log.error("获取rabbitmq连接异常：{}", e.getMessage());
        }
        return connection;
    }

    public Channel getChannel(Connection conn) {
        //创建一个新的连接
        Channel channel = null;
        try {
            channel = conn.createChannel();
            channel.queueBind("queueName"
                    , "exchangeName", "routeKey");
        } catch (IOException e) {
            log.error("获取rabbitmq连接异常：{}", e.getMessage());
        }


        /*channel.addConfirmListener(new ConfirmListener() {
            //消息发送成功并且在broker落地，deliveryTag是唯一标志符，在channek上发布的消息的deliveryTag都会比之前加1

            *//****
         * @param deliveryTag 消息id
         * @param multiple 是否批量
         *      如果是true，就意味着，小于等于deliveryTag的消息都处理成功了
         *      如果是false，只是成功了deliveryTag这一条消息
         * *//*
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("=========deliveryTag==========");
                System.out.println("deliveryTag: " + deliveryTag);
                System.out.println("multiple: " + multiple);
                //处理成功发送的消息
                if (multiple) {
                    //批量操作
                    for (Long id : new TreeSet<>(tags.headSet(deliveryTag + 1))) {
                        tags.remove(id);
                    }
                } else {
                    //单个确认
                    tags.remove(deliveryTag);
                }

                log.error("未处理的消息: " + tags);
            }

            *//**
         * @param deliveryTag 消息id
         * @param multiple 是否批量
         *      如果是true，就意味着，小于等于deliveryTag的消息都处理失败了
         *      如果是false，只是失败了deliveryTag这一条消息
         *//*
            //消息发送失败或者落地失败
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                log.error("===========handleNack===========");
                log.error("deliveryTag: " + deliveryTag);
                log.error("multiple: " + multiple);
            }
        });*/

        return channel;
    }


    public void closeConn(Connection conn, Channel channel) {
        try {
            if (channel != null && channel.isOpen()) {
                channel.close();
            }
            if (conn != null && conn.isOpen()) {
                conn.close();
            }
        } catch (IOException e) {
            log.error("关闭rabbitmq连接异常：{}", e.getMessage());
        } catch (TimeoutException e) {
            log.error("关闭rabbitmq连接超时：{}", e.getMessage());
        }
    }

    public static RabbitmqUtil getInstance() {
        return RabbitmqUtilHandler.instance;
    }

    private static class RabbitmqUtilHandler {
        public static RabbitmqUtil instance = new RabbitmqUtil();
    }

}
