package com.neo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
	@NotNull
	private String houseNo;
	
	@Column(name="streetName")
	@NotNull
	private String StreetName;
	
	@Column(name="cityName")
	@NotNull
	private String cityName;
	
	@Column(name="pinCode")
    @Min(111111)
    @Max(999999)
	private Integer pinCode;
	
	@Column(name="createDate",updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreateDate;
	
	@Column(name="updateDate")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;
	
	
	
}
