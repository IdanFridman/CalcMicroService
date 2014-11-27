package com.idan.calcservice.controller;

import com.idan.calcservice.kafka.KafkaProducer;
import com.idan.calcservice.kafka.KafkaProducerJava;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * Created by idan on 11/20/14.
 */
@RestController
public class CalcController {

    @Inject
    KafkaProducer kafkaProducer;

    @Inject
    KafkaProducerJava kafkaProducerJava;

    @RequestMapping("/")
    public String index() {
        kafkaProducer.sendMessageToKafka("Si Test");
        kafkaProducerJava.sendMsgToKafka("JavaTest");
        return "Greetings from Spring Boot!12333";
    }


}
