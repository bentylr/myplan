package com.love.config;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by bhagi on 10/9/2017.
 */
@Component
public class DynamoDBConfig {

    @Bean
    public DynamoDBMapper dynamoDBMapper() {
        AmazonDynamoDB amazonDynamoDB = AmazonDynamoDBAsyncClientBuilder.defaultClient();
        return new DynamoDBMapper(amazonDynamoDB);
    }
}
