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
@Table(name="User_Addres")
public class UserAddrsEntity {


	@Id
	@Column(name="userAddrsId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userEdu_id_generator")
	@SequenceGenerator(name="UserEdu_id_generator",
	                   initialValue = 1,allocationSize = 1,
	                   sequenceName = "userEdu_id_seq")
	private Integer userAddrsId;
	
	@Column(name="houseNo")
	private String houseNo;
	
	@Column(name="streetName")
	private String StreetName;
	
	@Column(name="cityName")
	private String cityName;
	
	@Column(name="pinCode")
	private Integer pinCode;
	
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
