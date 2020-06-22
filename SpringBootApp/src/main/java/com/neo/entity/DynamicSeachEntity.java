package com.neo.entity;

import javax.persistence.Access;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DynamicSeachEntity {
	private String firstName;
	private String lastName;
	private Integer pincode;
	private String email;
	

}
