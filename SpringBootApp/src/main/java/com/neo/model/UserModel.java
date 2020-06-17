package com.neo.model;

import java.util.Date;
import lombok.Data;

@Data
public class UserModel {

	private Integer userid;
	private String firstName;
	private String lastName;
	private String email;
	private long mobileNo;
	private String addrs;
	private Integer pincode;
	private Date dob;
	private Date doj;

}
