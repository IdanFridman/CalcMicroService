package com.idan.calcservice.mongo;

import com.idan.calcservice.Application;
import com.idan.calcservice.kafka.KafkaProducer;
import com.idan.calcservice.kafka.KafkaProducerJava;
import kafka.serializer.Encoder;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.integration.kafka.outbound.KafkaProducerMessageHandler;
import org.springframework.integration.kafka.serializer.common.StringEncoder;
import org.springframework.integration.kafka.support.KafkaProducerContext;
import org.springframework.integration.kafka.support.ProducerConfiguration;
import org.springframework.integration.kafka.support.ProducerFactoryBean;
import org.springframework.integration.kafka.support.ProducerMetadata;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.inject.Inject;
import java.util.Collections;

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
    public void sendMessageToKafka() {
        kafkaProducer.sendMessageToKafka("Hello Kafka From SI");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        // give the producer queues enough time to flush
        Thread.sleep(2000);
    }


    @Test
    public void test() throws Exception {
        KafkaProducerContext<String, String> kafkaProducerContext = new KafkaProducerContext<String, String>();
        ProducerMetadata<String, String> producerMetadata = new ProducerMetadata<String, String>("test");
        producerMetadata.setValueClassType(String.class);
        producerMetadata.setKeyClassType(String.class);
        Encoder<String> encoder = new StringEncoder<String>();
        producerMetadata.setValueEncoder(encoder);
        producerMetadata.setKeyEncoder(encoder);
        ProducerFactoryBean<String, String> producer = new ProducerFactoryBean<String, String>(producerMetadata, "localhost:9092");
        ProducerConfiguration<String, String> config = new ProducerConfiguration<String, String>(producerMetadata, producer.getObject());
        kafkaProducerContext.setProducerConfigurations(Collections.singletonMap("test", config));
        KafkaProducerMessageHandler<String, String> handler = new KafkaProducerMessageHandler<String, String>(kafkaProducerContext);
        handler.handleMessage(MessageBuilder.withPayload("foo123")
                .setHeader("messagekey", "3")
                .setHeader("topic", "test")
                .build());
    }


}
