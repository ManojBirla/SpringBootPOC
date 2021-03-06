package com.neo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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
	private Integer userMasterId;
	
	@NotNull(message = "please enter password")
	@Column(name="userName")
	private String userName;
	

	@NotNull(message = "please enter password")
	@Column(name="password")
	private String password;
	
	@Column(name="isActive")
	private Boolean isActive=true;
	
	@Column(name="createDate",updatable = false)
	@CreationTimestamp
	private Date CreateDate;
	
	@Column(name="updateDate")
	@UpdateTimestamp
	private Date updateDate;
	
	@OneToMany(targetEntity = UserAddrsEntity.class,
			cascade=CascadeType.ALL)
	@JoinColumn(name="userMsAddId")
	@Fetch(value=FetchMode.JOIN)
	private Set<UserAddrsEntity> usersAddrs;
	
	@OneToMany(targetEntity = UserEducationEntity.class,
			cascade=CascadeType.ALL)
	@JoinColumn(name="userMsEduId")
	@Fetch(value=FetchMode.JOIN)
	private Set<UserEducationEntity> usersEducation;
	
	

}
