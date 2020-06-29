package com.neo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.neo.model.UserAddress;

import lombok.Data;

@Data
@Document(collection="userdetails")
public class UserDtlsEntity {
	
	 @Id
	 private String uDId;
	 private String firstName;
	 private String lastName;
	 private String email;
	 private Long mobileNo;
	 private List<UserAddress> address;
	
	  

}
