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

@Data
@Entity
@Table(name="User_Education")
public class UserEducationEntity {

	@Id
	@Column(name="ureduid")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userEdu_id_generator")
	@SequenceGenerator(name="UserEdu_id_generator",
	                   initialValue = 1,allocationSize = 1,
	                   sequenceName = "userEdu_id_seq")
	private Integer userEduId;
	
	@Column(name="userScName")
	private String userScName;
	
	@Column(name="userScCityName")
	private String userScCityName;
	
	@Column(name="userClgName")
	private String userClgName;
	
	@Column(name="userBranchName")
	private String userBranchName;
	
	@Column(name="UserClgCityNam")
	private String UserClgCityName;
	
	@Column(name="createDate",updatable = false)
	@CreationTimestamp
	private Date CreateDate;
	
	@Column(name="updateDate")
	@UpdateTimestamp
	private Date updateDate;
	
	@OneToOne
	@JoinColumn(name="urMaster_id",nullable = false)
	private UserMasterEntity userMasterEntity;
	
}
