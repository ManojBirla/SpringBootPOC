package com.neo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name="User_Master")
public class UserMasterEntity {
	
	@Id
	@Column(name="userM_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userM_id_generator")
	@SequenceGenerator(name="UserM_id_generator",
	                   initialValue = 1,allocationSize = 1,
	                   sequenceName = "userM_id_seq")
	private Long userMasterId;
	
	@Column(name="userName")
	private String userName;
	

	@Column(name="password")
	private String password;
	
	@Column(name="isActive")
	private Boolean isActive;
	
	@Column(name="createDate",updatable = false)
	@CreationTimestamp
	private Date CreateDate;
	
	@Column(name="updateDate")
	@UpdateTimestamp
	private Date updateDate;

	
	

}
