package com.neo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.entity.ResponseEntityMessage;
import com.neo.entity.UserDtlsEntity;
import com.neo.entity.UserMasterEntity;
import com.neo.filter.CheckValidation;
import com.neo.model.UserDtlsModel;
import com.neo.model.UserMasterModel;
import com.neo.service.UserMasterService;

/**
 * THIS IS RESTCONTROLLER
 * 
 * @author MANOJ BIRLA DATE 16-JUNE-2020
 */
@RestController
public class UserMController extends CheckValidation {

	private static final Logger logger = LoggerFactory.getLogger(UserMController.class);

	@Autowired
	private UserMasterService umService;

	/**
	 * This methode is used to save userMaster 
	 * 
	 * @param Entity class Object
	 * @return message
	 */
	@PostMapping(value = "/usermasteRegistration", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveUserMaster(@RequestBody UserMasterModel umModel) {
		logger.info("saveUsermaster Started" );
		UserMasterEntity umEntity = new UserMasterEntity();
		BeanUtils.copyProperties(umModel, umEntity);
		ResponseEntity<?> response = null;
		try {
           response = validationForUserMaster(umEntity) ? responseBuilder(this.umService.insertUserMaster(umEntity))
					: null;
           if(response==null) {
        	   throw new Exception();
           }
           System.out.println(response);
			return response;
		} catch (Exception e) {
			logger.info("Error Message getRepresentativeDetailsByID:" + e.getMessage());
			logger.debug("Save Methode Execution Completed");
			return responseBuilder(new Exception("somthing went wrong"));
		}
	}

	/**
	 * This methode is used to getAllData of UserMaster
	 * 
	 * @param Entity class Object
	 * @return message
	 */
	@GetMapping(value = "/getUserMaster", produces = "Application/json")
	public ResponseEntity<?> getAllUser() {
		logger.info("getAll Started" );
		List<UserMasterEntity> list = (List<UserMasterEntity>) umService.fetchDataForuseMaster();
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}
	

	/**
	 * This methode is used to save userDtls
	 * 
	 * @param Entity class Object
	 * @return message
	 */
	@PostMapping(value = "/userDtlsRegistration", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> saveUserMasterDtls(@RequestBody UserDtlsModel umModel) {
		logger.info("saveUserDtls Started" );
		UserDtlsEntity uDEntity = new UserDtlsEntity();
		BeanUtils.copyProperties(umModel, uDEntity);
		ResponseEntity<?> response = null;
		try {
           response = validationForUserDtls(uDEntity) ? responseBuilder(this.umService.insertUserDtls(uDEntity))
					: null;
           if(response==null) {
        	   throw new Exception();
           }
			return response;
		}catch (Exception e){
			logger.info("Error Message getRepresentativeDetailsByID:" + e.getMessage());
			logger.debug("Save Methode Execution Completed");
			return responseBuilder(new Exception("somthing went wrong"));
		}}

}
