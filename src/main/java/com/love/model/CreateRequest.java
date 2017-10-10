package com.love.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CreateRequest {
    private String creationDate;
    private String userName;
    private String data;
}
