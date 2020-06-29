package com.neo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data

public class UserAddress {

	
	private String addresId;
	private String  fullAddres;
	private String type;
	private Integer pinCode;
}
