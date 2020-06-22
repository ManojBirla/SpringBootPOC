package com.neo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.neo.constants.AppConstants;
import com.neo.dao.UserMasterRepository;
import com.neo.dao.UserRepository;
import com.neo.entity.ResponseEntityMessage;
import com.neo.entity.UserEntity;
import com.neo.entity.UserMasterEntity;
import com.neo.service.UserService;
import com.neo.service.UserServiceImpl;

/**
 * THIS IS Test cases for controller
 * 
 * @author MANOJ BIRLA DATE 16-JUNE-2020
 */
@ExtendWith(MockitoExtension.class)
public class ServiceTest {

	@Mock
	private static UserRepository userRepo;

	// userMaster Repository instance
	@Autowired
	private UserMasterRepository userMasterRepo;

	@InjectMocks
	private static UserService serviceImpl = new UserServiceImpl();

	UserEntity entity = null;
	UserEntity failEntity = null;
	ResponseEntityMessage resMsg = null;
	ResponseEntityMessage failResMsg = null;
	UserMasterEntity uMentity = null;
	UserMasterEntity ufailMentity = null;

	String fname = "Ram";
	String lname = "Kumar";
	List<UserEntity> list = null;

	@BeforeEach
	public void setUpForTestin() {

		uMentity = new UserMasterEntity();
		uMentity.setUserMasterId(201);
		uMentity.setUserName("Amit");
		uMentity.setPassword("78Am");

		ufailMentity = new UserMasterEntity();
		ufailMentity.setUserMasterId(null);
		ufailMentity.setUserName("Amit");
		ufailMentity.setPassword("78Am");
		entity = new UserEntity();
		entity.setUserid(2);
		entity.setFirstName("Ram");
		entity.setLastName("kumar");
		entity.setMobileNo(787878);

		resMsg = new ResponseEntityMessage();
		resMsg.setMessage(AppConstants.SUCCESSINSERTMESSAGE);
		resMsg.setStatusCode(200);
		resMsg.setUserId(entity.getUserid());

		failEntity = new UserEntity();
		failEntity.setUserid(null);
		failResMsg = new ResponseEntityMessage();
		failResMsg.setMessage(AppConstants.FAILINSERTMESSAGE);
		failResMsg.setStatusCode(400);
		failResMsg.setUserId(null);

		list = new ArrayList<>();
		list.add(entity);

	}

	/**
	 * This methode is used to getAllUsersTest
	 * 
	 * @return void
	 */
	@Test
	public void getAllUsers() {
		Mockito.when(userRepo.findAll()).thenReturn(list);
		assertEquals(list, serviceImpl.fetchAllUsers());
	}

	/**
	 * This methode is used to saveUserMaster Details
	 * 
	 * @return void
	 */
	@Test
	public void saveUserMasterDtls() {
		Mockito.when(userMasterRepo.save(uMentity)).thenReturn(uMentity);
		assertEquals(resMsg, serviceImpl.saveUserMaster(uMentity));
	}
	
	/**
	 * This methode is used to saveUserMaster if failed
	 * 
	 * @return void
	 */
	@Test
	public void saveUserMasterDtlsFailed() {
		Mockito.when(userMasterRepo.save(ufailMentity)).thenReturn(ufailMentity);
		assertEquals(failResMsg, serviceImpl.saveUserMaster(ufailMentity));
	}

	/**
	 * This methode is used to saveuserDtlls is response Success
	 * 
	 * @return void
	 */
	@Test
	public void saveUserTestIfSucces() {

		Mockito.when(userRepo.save(entity)).thenReturn(entity);
		assertEquals(resMsg, serviceImpl.saveUser(entity));
	}

	@Test
	public void saveUserTestIfFailed() {
		Mockito.when(userRepo.save(failEntity)).thenReturn(failEntity);
		assertEquals(failResMsg, serviceImpl.saveUser(failEntity));
	}

	@Test
	public void modifyUserDetailsIfSuccess() throws Exception {
		resMsg.setMessage(AppConstants.SUCCESSUPDATEMESSAGE);
		Mockito.when(userRepo.save(entity)).thenReturn(entity);
		assertEquals(resMsg, serviceImpl.modifyUserDetails(entity, entity.getUserid()));

	}

	@Test
	public void modifyUserDetailsIfFailed() throws Exception {
		failResMsg.setMessage(AppConstants.FAILUPDATEMESSAGE);
		failResMsg.setStatusCode(304);
		// Mockito.when(userRepo.save(failEntity)).thenReturn(failEntity);
		assertEquals(failResMsg, serviceImpl.modifyUserDetails(failEntity, failEntity.getUserid()));

	}

	@Test
	public void findUserByFnameAndLnameIfSuccess() throws Exception {

		Mockito.when(userRepo.findByFnameOrLastName(fname, lname)).thenReturn(list);
		assertEquals(list, serviceImpl.findUserByFnameAndLname(fname, lname));

	}

	/*
	 * @Test public void sortingUsers()throws Exception{
	 * Mockito.when(userRepo.sortUserByDobAndDoj()).thenReturn(list);
	 * assertEquals(list,serviceImpl.findUserByFnameAndLname(fname, lname));
	 * 
	 * }
	 */

	@Test
	public void deleteUserDetailsByIdIfSuccess() throws Exception {
		resMsg.setMessage(AppConstants.SUCCESSDELETEMESSAGE);
		resMsg.setUserId(null);
		doNothing().when(userRepo).softDelete(entity.getUserid());
		assertEquals(resMsg, serviceImpl.deleteUserDetailsById(entity.getUserid()));

	}

	@Test
	public void deleteUserDetailsByIdIfFailed() throws Exception {
		failResMsg.setMessage(AppConstants.FAILDELETEMESSAGE);
		failResMsg.setStatusCode(204);

		// doNothing().when(userRepo).softDelete(entity.getUserid());
		assertEquals(failResMsg, serviceImpl.deleteUserDetailsById(failEntity.getUserid()));

	}

}
