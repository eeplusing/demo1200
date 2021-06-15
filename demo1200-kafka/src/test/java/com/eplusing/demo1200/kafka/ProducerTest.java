package com.eplusing.demo1200.kafka;

import static org.junit.Assert.assertTrue;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;

import java.util.Properties;


public class ProducerTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

      /*  long startTime = System.currentTimeMillis();
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.145.131:2181,192.168.145.132:2181,192.168.145.133:2181");
        props.put("acks", "0");
        props.put("retries", 3);
        props.put("batch.size", 16384); // 16K
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432); // 32M
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("max.block.ms", "1000");

        Producer producer = new KafkaProducer<>(props);

        int i = 0;
        while (i < 100000) {
            // 创建 ProducerRecord 可以指定 topic、partition、key、value，其中 partition 和 key 是可选的
            // ProducerRecord<String, String> record = new ProducerRecord<>("dev3-yangyunhe-topic001", 0, "key", line);
            // ProducerRecord<String, String> record = new ProducerRecord<>("dev3-yangyunhe-topic001", "key", line);
            ProducerRecord<String, String> record = new ProducerRecord<>("dev3-yangyunhe-topic001", i + "");

            // 只管发送消息，不管是否发送成功
            producer.send(record);

            //同步
            *//*try {
                RecordMetadata recordMetadata = (RecordMetadata) producer.send(record).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }*//*
            i++;
        }
        long endTime = System.currentTimeMillis();

        System.out.println(endTime - startTime);
        producer.close();
*/

    }
}
