package com.neo.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.constants.AppConstants;
import com.neo.controller.UserRegController;
import com.neo.dao.UserRepository;
import com.neo.entity.ResponseEntityMessage;
import com.neo.entity.UserEntity;

/**
 * THIS IS IMPLEMENTATION FOR SERVICE LAYER
 * @author MANOJ BIRLA DATE 16-JUNE-2020
 */
@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserRegController.class);

	@Autowired
	public UserRepository repo;

	/**
	 * This methode is used to register User details
	 * 
	 * @param Entity class Object
	 * @return message
	 */
	public ResponseEntityMessage saveUser(UserEntity entity){
		logger.debug("saveUser Methode Execution Started");
		UserEntity urEntity = new UserEntity();
		ResponseEntityMessage response=new ResponseEntityMessage();
		if (entity != null) {
			urEntity = repo.save(entity);
			System.out.println(urEntity);
			Integer userId = urEntity.getUserid();
			if (userId != null) {
				response.setMessage(AppConstants.successInsertMessage);
				response.setStatusCode(200);
				response.setUserId(userId);
				
				return response;
			}
			response.setMessage(AppConstants.failInsertMessage);
			response.setStatusCode(400);
			logger.debug("saveUser Methode Execution ended");
			return response;
		}
		response.setMessage(AppConstants.failInsertMessage);
		response.setStatusCode(400);
		return response;
	}
	
	/**
	 * This methode is used to modify Representative Data.
	 * 
	 * @param Representative Details entity and Integer as Representative Id.
	 * @return message
	 */
	public ResponseEntityMessage modifyUserDetails(UserEntity entity, Integer userId)
			throws Exception {
		logger.debug("Update Methode Execution Started");
		UserEntity updateEntity = new UserEntity();
		ResponseEntityMessage response=new ResponseEntityMessage();
		
		if(userId!=null) {
		entity.setUserid(userId);
		logger.info("Before Update " + entity);
		updateEntity = repo.save(entity);
		logger.info("After Update " + updateEntity);
		logger.debug("Update Methode Execution Completed");
		response.setMessage(AppConstants.successUpdateMessage);
		response.setUserId(updateEntity.getUserid());
		response.setStatusCode(200);
		return response;
		}
		response.setMessage(AppConstants.failUpdateMessage);
		response.setStatusCode(304);
		return response;
	}
	
	
	/**
	 * This methode is used to find users by fname and lname
	 * 
	 * @param 
	 * @return list of Users
	 */
	@Override
	public List<UserEntity> findUserByFnameAndLname(String fname,String lname) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("findUserByFnameAndLname Methode Execution Started");
		UserEntity getUser=new UserEntity();
		List<UserEntity> list=new ArrayList<>();

			list=repo.findByFnameOrLastName(fname, lname);
		
		System.out.println(getUser);
		logger.debug("findUserByFnameAndLname Methode Execution ended");
		return list;
	}
	
	
	/**
	 * This methode is used to sorting users list by dob and doj
	 * 
	 * @param 
	 * @return list of Users
	 */
	@Override
	public List<UserEntity> sortingUsers() throws Exception {
		
		return repo.sortUserByDobAndDoj();
	}
	
	/**
	 * This methode is used to delete representative details by id
	 * 
	 * @param Integer Representative Id
	 * @return message
	 */
	public ResponseEntityMessage deleteUserDetailsById(Integer userId) throws Exception {
		logger.debug("Delete Methode Execution Started");
		ResponseEntityMessage response=new ResponseEntityMessage();
		if (userId != null) {
			response.setMessage(AppConstants.successDeleteMessage);
			response.setStatusCode(200);
			//repo.deleteById(userId);
			repo.softDelete(userId);
			return response;
		}
		response.setMessage(AppConstants.failDeleteMessage);
		response.setStatusCode(204);
		logger.debug("Delete Methode Execution Completed");
		return response;
	}
	
}
