package com.neo.dao;

import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neo.entity.UserEntity;

/**
 * THIS IS Repository Class
 * @author MANOJ BIRLA DATE 16-JUNE-2020
 */
public interface UserRepository extends CrudRepository<UserEntity, Serializable> {

	@Query("select e from UserEntity e where e.firstName like :fname% OR e.lastName like :lname% OR e.email like :email%" )
	public List<UserEntity> findByFnameOrLastNameAndEmail(String fname, String lname,String email);

	@Query("select e from UserEntity e where e.firstName like :fname% OR e.lastName like :lname%")
	public List<UserEntity> findByFnameOrLastName(String fname, String lname);

	@Query("select e from UserEntity e order by dob,doj")
	public List<UserEntity> sortUserByDobAndDoj();

	@Modifying
	@Transactional
	@Query("update UserEntity e set e.isActive=false where e.userid =:id")
	public void softDelete(Integer id);

}