package com.neo.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class UserAddressEntity {

	@Id
	private String addresId;
	private String  fullAddres;
	private String type;
	private Integer pinCode;
}
