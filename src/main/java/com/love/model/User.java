package com.love.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by bhagi on 10/2/2017.
 */
@Data
public class User {
    @Id
    private String userName;
    private String passWord;
    private String firstName;
    private String emailId;
}
