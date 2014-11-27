package com.idan.calcservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by idan on 11/25/14.
 */
@Named
public class KafkaProducer {

    @Inject
    MessageChannel inputToKafka;


    public void sendMessageToKafka(String message) {
        inputToKafka.send(
                MessageBuilder.withPayload(message)
                        .setHeader("messageKey", "1")
                        .setHeader("topic", "test")
                        .build());

    }




}
