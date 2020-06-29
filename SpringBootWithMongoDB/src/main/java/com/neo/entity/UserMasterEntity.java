package com.neo.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection ="usermaster")
public class UserMasterEntity {
	
	
	
	@Id
	private String userMId;
	private String userName;
	private String password;
	private boolean isActive;
	private Date createDate;
	private Date updateDate;
}
