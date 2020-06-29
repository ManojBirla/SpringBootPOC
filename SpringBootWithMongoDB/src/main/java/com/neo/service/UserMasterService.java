package com.neo.service;



import java.util.List;

import com.neo.entity.ResponseEntityMessage;
import com.neo.entity.UserDtlsEntity;
import com.neo.entity.UserMasterEntity;

public interface UserMasterService {
	
	public ResponseEntityMessage insertUserMaster(UserMasterEntity umEntity);
    public List<?> fetchDataForuseMaster();
    public ResponseEntityMessage insertUserDtls(UserDtlsEntity uDEntity);
	
}
