package com.neo.service;

import java.util.List;

import com.neo.entity.ResponseEntityMessage;
import com.neo.entity.UserEntity;

/**
 * THIS IS INTERFACE FOR SERVICE LAYER
 * @author MANOJ BIRLS DATE 16-JUNE-2020
 */
public interface UserService {

	
	public ResponseEntityMessage saveUser(UserEntity entity);
	public ResponseEntityMessage modifyUserDetails(UserEntity entity, Integer userId)throws Exception ;
    public List<UserEntity> findUserByFnameAndLname(String fname,String lname)throws Exception; 
    public List<UserEntity> sortingUsers()throws Exception; 
    public ResponseEntityMessage deleteUserDetailsById(Integer userId) throws Exception;

}
