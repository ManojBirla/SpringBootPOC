package com.neo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;


/**
 * THIS IS USERENTITY Class
 * @author MANOJ BIRLA DATE 16-JUNE-2020
 */
@Data
@Entity
@Table(name="user_details")
public class UserEntity {

	@Column(name = "userid")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
	@SequenceGenerator(name="user_id_generator",
	                   initialValue = 1,allocationSize = 1,
	                   sequenceName = "user_id_seq")
	private Integer userid;
	
	@Column(name ="fname")
	private String firstName;
	
	@Column(name ="lname")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobileNo")
	private long mobileNo;
	
	@Column(name="addrs")
	private String addrs;
	
	
	@Column(name ="pincode")
	private Integer pincode;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="doj")
	private Date doj;
	
	@Column(name="createDate",updatable = false)
	@CreationTimestamp
	private Date CreateDate;
	
	@Column(name="updateDate")
	@UpdateTimestamp
	private Date updateDate;

	@Column(name = "is_active")
	private boolean isActive = true;
	
	@OneToOne
	@JoinColumn(name="urMaster_id",nullable = false)
	private UserMasterEntity userMasterEntity;
}
