package com.neo.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.neo.entity.UserAddrsEntity;

public interface UserAddressRepository extends CrudRepository<UserAddrsEntity, Serializable> {

}
