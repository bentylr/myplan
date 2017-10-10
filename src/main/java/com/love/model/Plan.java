package com.love.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by bhagi on 10/9/2017.
 */
@Getter
@Setter
@ToString
@DynamoDBTable(tableName = "love.plans")
public class Plan {

    @DynamoDBHashKey
    private String dateName;
    @DynamoDBRangeKey
    @DynamoDBGeneratedUuid(value = DynamoDBAutoGenerateStrategy.CREATE)
    private String id;
    private String data;
}
