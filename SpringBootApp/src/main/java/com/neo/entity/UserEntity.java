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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	                   sequenceName = "userdtls_id_seq")
	private Integer userid;
	
	
	@Column(name ="fname")
	@NotNull
	private String firstName;
	
	@Column(name ="lname")
	@NotNull
	private String lastName;
	
	
	@Column(name="email")
	@NotNull
    @Pattern(regexp = "^([A-Za-z0-9])(([.])?[0-9a-z])*[@]([a-z])+([.]([a-z])+){1,3}",message = "Invalid Email-Id")
	private String email;
	
	@Column(name="mobileNo")
	private long mobileNo;
	
	
	@Column(name="dob")
	@NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Madrid")
	private Date dob;
	
	@Column(name="doj")
	@NotNull
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Europe/Madrid")
	private Date doj;
	
	@Column(name="createDate",updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreateDate;
	
	
	@Column(name="updateDate")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	@Column(name = "is_active")
	private boolean isActive = true;
	
	@OneToOne
	@JoinColumn(name="urMaster_id",nullable = false)
	private UserMasterEntity userMasterEntity;
}
