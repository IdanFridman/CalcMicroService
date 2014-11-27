package com.idan.calcservice.mongo;

import com.idan.calcservice.Application;
import com.idan.calcservice.kafka.KafkaProducer;
import com.idan.calcservice.kafka.KafkaProducerJava;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;

/**
 * Created by idan on 11/25/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = {Application.class})
@IntegrationTest
public class TestKafka {

    @Inject
    KafkaProducer kafkaProducer;

    @Inject
    KafkaProducerJava kafkaProducerJava;

    @Test
    public void sendMessageToKafka()
    {
        kafkaProducer.sendMessageToKafka("Hello Kafka From SI");

    }


}
