package com.neo.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.neo.entity.UserMasterEntity;

public interface UserMasterRepository extends MongoRepository<UserMasterEntity, ObjectId>{

}
