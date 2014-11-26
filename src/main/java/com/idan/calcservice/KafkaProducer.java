package com.idan.calcservice;

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

    @Autowired
    @Qualifier("inputToKafka")
    MessageChannel inputToKafka;



    public void sendMessageToKafka(String message)
    {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputToKafka.send(
                MessageBuilder.withPayload(message)
                        .setHeader("messageKey", "3")
                        .setHeader("topic", "zerg.hydra").build());

    }


}
