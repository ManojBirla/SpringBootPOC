package com.neo.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.neo.entity.UserDtlsEntity;

public interface UserDtlsRepository extends MongoRepository<UserDtlsEntity, ObjectId>{

}
