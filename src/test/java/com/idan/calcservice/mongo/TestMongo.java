package com.idan.calcservice.mongo;

import com.idan.calcservice.Application;
import com.idan.calcservice.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.apache.log4j.Logger;

import javax.inject.Inject;

/**
 * Created by idan on 11/23/14.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringApplicationConfiguration(classes = {Application.class})
@IntegrationTest
public class TestMongo {

    private Logger log = Logger.getLogger(TestMongo.class);

    @Autowired
    @Qualifier("mongoAdapter")
    MessageChannel mongoAdapter;


    @Test
    public void insertDocTest() {
        if (mongoAdapter != null) {
            mongoAdapter.send(new GenericMessage<Object>(createPersonA()));
        }


    }

    private Person createPersonA() {

        Person person = new Person();
        person.setName("John");
        person.setLocation(1111);
        return person;
    }

    private Person createPersonB() {
        Person person = new Person();
        person.setName("Idan");
        person.setLocation(2222);
        return person;
    }

}
