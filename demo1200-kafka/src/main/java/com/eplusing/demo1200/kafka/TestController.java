package com.eplusing.demo1200.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {

    @Autowired
    KafkaProducer producer;


    @GetMapping("/kafka/producer")
    public void producer(){
        log.info("生产消息");
        producer.send("生产helloworld");

    }
}
