package com.neo.dao;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import com.neo.entity.UserAddrsEntity;
import com.neo.entity.UserContract;

public interface UserContractRepository extends CrudRepository<UserContract, Serializable> {

}
