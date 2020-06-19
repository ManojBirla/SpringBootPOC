package com.neo.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neo.constants.AppConstants;
import com.neo.entity.ResponseEntityMessage;
import com.neo.entity.UserEntity;
import com.neo.entity.UserMasterEntity;
import com.neo.service.UserService;

/**
 * THIS IS RESTCONTROLLER
 * 
 * @author MANOJ BIRLA DATE 16-JUNE-2020
 */
@RestController
public class UserRegController {

	private static final Logger logger = LoggerFactory.getLogger(UserRegController.class);

	//UserDetails Service
	@Autowired
	public UserService service;
	
	
	/**
	 * This methode is used to insert Data of User Master
	 * 
	 * @param mrId
	 * @return ResponseEntity<String> message
	 */
	@GetMapping("/getAllUsers")
	public List<UserEntity> getAllUsers(){
		logger.debug("saveUser Method Execute" );
		return service.fetchAllUsers();
	}
	
	

	/**
	 * This methode is used to insert Data of User Master
	 * 
	 * @param mrId
	 * @return ResponseEntity<String> message
	 */
	@PostMapping(value = "/userMasterRegistration", produces = "Application/json")
	public ResponseEntity<ResponseEntityMessage> insertUserMaster(@RequestBody UserMasterEntity entity) {
		logger.debug("Save Methode Execution Started");
		System.out.println("My "+ entity );
		ResponseEntityMessage response = new ResponseEntityMessage();
		try {

			response = service.saveUserMaster(entity);
			return new ResponseEntity<ResponseEntityMessage>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage(AppConstants.FAILINSERTMESSAGE);
			response.setStatusCode(204);
			logger.info("Error Message getRepresentativeDetailsByID:" + e.getMessage());
			logger.debug("Save Methode Execution Completed");
			return new ResponseEntity<ResponseEntityMessage>(HttpStatus.CONFLICT);
		}
	}

	/**
	 * This methode is used to updateUserDetailsById
	 * 
	 * @param entity
	 * @param mrId
	 * @return ResponseEntity<String> message
	 */
	@PostMapping(value = "/userdtlsregister", produces = { "application/json" })
	public ResponseEntity<ResponseEntityMessage> registerUser(@RequestBody UserEntity entity) {
		logger.debug("Save Methode Execution Started");
		System.out.println("userdtlsregister");
		ResponseEntityMessage response = new ResponseEntityMessage();
		try {

			response = service.saveUser(entity);
			return new ResponseEntity<ResponseEntityMessage>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage(AppConstants.FAILINSERTMESSAGE);
			response.setStatusCode(204);
			logger.info("Error Message getRepresentativeDetailsByID:" + e.getMessage());
			logger.debug("Save Methode Execution Completed");
			return new ResponseEntity<ResponseEntityMessage>(HttpStatus.CONFLICT);
		}

	}

	/**
	 * This methode is used to updateUserDetailsById
	 * 
	 * @param entity
	 * @param mrId
	 * @return ResponseEntity<String> message
	 */
	@PutMapping(value = "/updateUserDetailsById", produces = { "application/json" })
	public ResponseEntity<ResponseEntityMessage> updateUserDetailsById(@RequestBody UserEntity entity,
			@RequestParam("id") Integer userId) {
		logger.debug("UpdateUserDetailsById Method Execution Started");
		System.out.println("for update id " + userId  +" ent: "+entity);
		ResponseEntityMessage response = new ResponseEntityMessage();
		try {
			response = service.modifyUserDetails(entity, userId);
			logger.info("This MR_Id " + response);
			logger.debug("UpdateRepresentativeDetailsById Method Execution Completed");
			return new ResponseEntity<ResponseEntityMessage>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage(AppConstants.FAILUPDATEMESSAGE);
			response.setStatusCode(304);
			logger.error("Error Message");
			logger.debug("UpdateUserDetailsById Method Execution Completed");
			return new ResponseEntity<ResponseEntityMessage>(response, HttpStatus.NOT_MODIFIED);
		}

	}

	/**
	 * This methode is used to search users
	 * 
	 * @param entity
	 * @param mrId
	 * @return users list
	 */
	@GetMapping(value = "/searchByName", produces = { "application/json" })
	public List<UserEntity> searchUser(@RequestParam("fname") String fname, @RequestParam("lname") String lname) {
		logger.debug("searchUser Method Execution Started");
		UserEntity entity = new UserEntity();
		List<UserEntity> list = new ArrayList<>();
		try {
			list = service.findUserByFnameAndLname(fname, lname);
			System.out.println(entity.getFirstName() + " yyy " + entity);
			return list;
		} catch (Exception e) {
			logger.error("Error Message");
			logger.debug("UpdateUserDetailsById Method Execution Completed");
			System.out.println("exception");
			return list;
		}
	}

	/**
	 * This methode is used to sorting users list
	 * 
	 * @param entity
	 * @param mrId
	 * @return users list
	 */
	@GetMapping(value = "/sortingByDates", produces = { "application/json" })
	public List<UserEntity> sortingUsers() {
		logger.debug("sortingUsers Method Execution Started");
		UserEntity entity = new UserEntity();
		List<UserEntity> list = new ArrayList<>();
		try {
			list = service.sortingUsers();
			return list;
		} catch (Exception e) {
			logger.debug("sortUserDetailsByDates Method Execution Completed");
			System.out.println("exception");
			return list;
		}
	}

	/**
	 * This methode is used to deleteRepresentativeById
	 * 
	 * @param mrId
	 * @return ResponseEntity<String> message
	 */
	@PutMapping(value = "/deleteUserById", produces = { "application/json" })
	public ResponseEntity<ResponseEntityMessage> deleteUserById(@RequestParam("id") Integer userId) {
		logger.debug("DeleteRepresentativeById Method Execution Started");
		System.out.println("DeleteRepresentativeById Method Execution Started");
		ResponseEntityMessage response = new ResponseEntityMessage();
		try {
			response = service.deleteUserDetailsById(userId);
			logger.debug("DeleteRepresentativeById Method Execution Completed");
			return new ResponseEntity<ResponseEntityMessage>(response, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage(AppConstants.FAILDELETEMESSAGE);
			response.setStatusCode(304);
			logger.error("Error Message deleteUserById:" + e.getMessage());
			logger.debug("DeleteUserById Method Execution Started");
			return new ResponseEntity<ResponseEntityMessage>(response, HttpStatus.NO_CONTENT);
		}
	}

}
