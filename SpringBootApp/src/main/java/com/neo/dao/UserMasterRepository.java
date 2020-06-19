package com.neo.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.neo.entity.UserMasterEntity;

/**
 * THIS IS Repository Class
 * @author MANOJ BIRLA DATE 16-JUNE-2020
 */
public interface UserMasterRepository  extends CrudRepository<UserMasterEntity, Serializable>{

}
