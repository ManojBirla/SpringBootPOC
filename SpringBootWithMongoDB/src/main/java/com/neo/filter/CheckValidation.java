package com.neo.filter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.neo.constants.AppConstants;
import com.neo.entity.ResponseEntityMessage;
import com.neo.entity.UserDtlsEntity;
import com.neo.entity.UserMasterEntity;

public abstract class CheckValidation {

	/**
	 * This methode is used to validation for UserMaster table
	 * 
	 * @param Entity class Object
	 * @return message
	 */
	public boolean validationForUserMaster(UserMasterEntity entity) {
		if (entity.getUserName() != null && entity.getPassword() != null) {
			System.out.println(true);
			return true;
		} else {
			return false;
		}
	}

	
	/**
	 * This methode is used to validation for UserDtls table
	 * 
	 * @param Entity class Object
	 * @return message
	 */
	public boolean validationForUserDtls(UserDtlsEntity entity) {
		if (entity.getFirstName() != null && entity.getLastName() != null &&
			entity.getEmail() !=null && entity.getMobileNo()!=null && 
			entity.getAddress()!=null) {
			 System.out.println(true);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This methode is used to giving positive response
	 * 
	 * @param Entity class Object
	 * @return message
	 */
	public ResponseEntity<Object> responseBuilder(Object user) throws Exception {
		ResponseEntityMessage resEntMsg = new ResponseEntityMessage();
		resEntMsg.setMessage(AppConstants.SUCCESSINSERTMESSAGE);
		resEntMsg.setStatusCode(200);
		//resEntMsg.setUserId();
		return new ResponseEntity<Object>(resEntMsg, HttpStatus.OK);
	}

	/**
	 * This methode is used to Negetive response
	 * 
	 * @param Entity class Object
	 * @return message
	 */
	public ResponseEntity<Object> responseBuilder(Exception exc) {
		ResponseEntityMessage resEntMsg = new ResponseEntityMessage();
		resEntMsg.setMessage(AppConstants.FAILINSERTMESSAGE);
		resEntMsg.setStatusCode(409);
		//resEntMsg.setUserId(userId);
		return new ResponseEntity<Object>(resEntMsg, HttpStatus.CONFLICT);

	}
}
