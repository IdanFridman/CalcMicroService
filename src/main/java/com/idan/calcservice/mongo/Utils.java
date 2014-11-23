package com.idan.calcservice.mongo;

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

/**
 * Created by idan on 11/23/14.
 */
public class Utils {

    public static MongoDbFactory prepareMongoFactory(String... additionalCollectionToDrop) throws Exception{
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(new MongoClient(), "test");
        MongoTemplate template = new MongoTemplate(mongoDbFactory);
        template.dropCollection("testData");
        for (String additionalCollection : additionalCollectionToDrop) {
            template.dropCollection(additionalCollection);
        }
        return mongoDbFactory;
    }
}
