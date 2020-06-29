package com.neo.model;

import java.util.Date;

import lombok.Data;

@Data
public class UserMasterModel {
	
	private Integer userId;
	private String userName;
	private String password;
	private boolean isActive;
	private Date createDate;
	private Date updateDate;
	
	

}
