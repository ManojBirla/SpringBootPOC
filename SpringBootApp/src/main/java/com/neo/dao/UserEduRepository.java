package com.neo.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.neo.entity.UserEducationEntity;

public interface UserEduRepository extends CrudRepository<UserEducationEntity, Serializable> {

}
