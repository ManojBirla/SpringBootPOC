package com.neo.entity;

import lombok.Data;

@Data
public class ResponseEntityMessage {
    private Integer statusCode;
    private String userId;
    private  String message;
}
