package com.neo.model;

import java.util.List;

import lombok.Data;

@Data
public class UserDtlsModel {


	 private String uDId;
	 private String firstName;
	 private String lastName;
	 private String email;
	 private Long mobileNo;
	 private List<UserAddress> address;
		
	
}
