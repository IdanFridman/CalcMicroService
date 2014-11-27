package com.idan.calcservice.kafka;

/**
 * Created by idan on 11/26/14.
 */

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import java.util.Properties;

@Named
public class KafkaProducerJava {

    ProducerConfig config=null;
    Producer<String, String> producer;
    Properties props=null;

    @PostConstruct
    public void init()
    {
        props = new Properties();

        props.put("metadata.broker.list", "localhost:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
       // props.put("partitioner.class", "example.producer.SimplePartitioner");
        props.put("request.required.acks", "1");



    }


    public void sendMsgToKafka(String msg)
    {
        config= new ProducerConfig(props);
        producer=new Producer<String, String>(config);
        KeyedMessage<String, String> data = new KeyedMessage<String, String>("test", "", msg);

        producer.send(data);
        producer.close();




    }




}
