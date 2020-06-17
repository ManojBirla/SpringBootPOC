package com.neo.entity;

import lombok.Data;

@Data
public class ResponseEntityMessage {
    private Integer statusCode;
    private Integer userId;
    private  String message;
}
