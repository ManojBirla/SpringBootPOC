package com.neo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.constants.AppConstants;
import com.neo.dao.UserDtlsRepository;
import com.neo.dao.UserMasterRepository;
import com.neo.entity.ResponseEntityMessage;
import com.neo.entity.UserDtlsEntity;
import com.neo.entity.UserMasterEntity;

/**
 * THIS IS SERVICE IMPLEMENTATION
 * 
 * @author MANOJ BIRLA DATE 16-JUNE-2020
 */
@Service
public class UserMasterServiceImpl implements UserMasterService {

	private static final Logger logger = LoggerFactory.getLogger(UserMasterServiceImpl.class);

	@Autowired
	private UserMasterRepository userMasterRepo;
	
	@Autowired
	private UserDtlsRepository userDtlsRepo;
	
	/**
	 * This methode is used to insert userMaster 
	 * 
	 * @param Entity class Object
	 * @return message
	 */
	@Override
	public ResponseEntityMessage insertUserMaster(UserMasterEntity entity) {
		logger.info("insertUserMaster Started" );
		ResponseEntityMessage response=new ResponseEntityMessage();
		UserMasterEntity urMasterEntity = new UserMasterEntity();
		if (entity != null) {
			
			urMasterEntity = userMasterRepo.save(entity);
			String userId = urMasterEntity.getUserMId();
			if (userId != null) {
				response.setMessage(AppConstants.SUCCESSINSERTMESSAGE);
				response.setStatusCode(200);
				response.setUserId(userId);
				
				return response;
			}
			response.setMessage(AppConstants.FAILINSERTMESSAGE);
			response.setStatusCode(400);
			//logger.debug("saveUser Methode Execution ended");
			return response;
		}
		response.setMessage(AppConstants.FAILINSERTMESSAGE);
		response.setStatusCode(400);
		logger.info("insertUserMaster ended" );
		return response;
	}
	
	/**
	 * This methode is used to fetch AllUserMaster
	 * 
	 * @param Entity class Object
	 * @return message
	 */
	@Override
	public List<?> fetchDataForuseMaster() {
		logger.info("fetchDataForuseMaster Started" );
		List<UserMasterEntity> umList = userMasterRepo.findAll();
		return umList;
	}
	/**
	 * This methode is used to insertUserDtls 
	 * 
	 * @param Entity class Object
	 * @return message
	 */
	@Override
	public ResponseEntityMessage insertUserDtls(UserDtlsEntity entity) {
		logger.info("insertUserDtls Started" );
		ResponseEntityMessage response=new ResponseEntityMessage();
		UserDtlsEntity urDtlsEntity = new UserDtlsEntity();
		if (entity != null) {
			
			urDtlsEntity = userDtlsRepo.save(entity);
			String userId = urDtlsEntity.getUDId();
			if (userId != null) {
				response.setMessage(AppConstants.SUCCESSINSERTMESSAGE);
				response.setStatusCode(200);
				response.setUserId(userId);
				System.out.println(userId);
				return response;
			}
			response.setMessage(AppConstants.FAILINSERTMESSAGE);
			response.setStatusCode(400);
			//logger.debug("saveUser Methode Execution ended");
			return response;
		}
		response.setMessage(AppConstants.FAILINSERTMESSAGE);
		response.setStatusCode(400);
		logger.info("insertUserDtls ended" );
		return response;
	}

}
