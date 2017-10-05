package com.love.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by bhagi on 10/3/2017.
 */
@Component
public class MongoConfig {

    @Autowired
    private MongoDbFactory mongoDbFactory;



}
