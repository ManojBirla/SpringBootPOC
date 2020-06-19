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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "User_contract")
public class UserContract {

	@Id
	@Column(name = "userContractId")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userEdu_id_generator")
	@SequenceGenerator(name = "UserEdu_id_generator", initialValue = 1, allocationSize = 1, sequenceName = "userEdu_id_seq")
	private Integer userContractId;

	@Column(name = "companyName")
	@NotNull
	private String companyName;

	@Column(name = "duration")
	@NotNull
	private String duration;

	@Column(name = "exp")
	@NotNull
	private String exp;

	@Column(name = "createDate", updatable = false)
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date CreateDate;

	@Column(name = "updateDate")
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateDate;

	@OneToOne
	@JoinColumn(name = "urMaster_id", nullable = false)
	private UserMasterEntity userMasterEntity;

}
