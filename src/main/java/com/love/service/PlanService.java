package com.love.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.love.model.Plan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bhagi on 10/9/2017.
 */
@Service
public class PlanService {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public void persist(Plan plan) {
        dynamoDBMapper.save(plan);
    }

    public List<Plan> getPlans(String creationDateName) {
        Map<String, AttributeValue> eav = new HashMap<>();
        eav.put(":creationDateName", new AttributeValue().withS(creationDateName));

        DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression<>()
                .withKeyConditionExpression("creationDateName = :creationDateName")
                .withExpressionAttributeValues(eav);
        return dynamoDBMapper.query(Plan.class, queryExpression);
    }
}
