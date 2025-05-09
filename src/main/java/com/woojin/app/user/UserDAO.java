package com.woojin.app.user;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
	
	public int join(UserVO userVO) throws Exception;
	
	public UserVO detail(UserVO userVO) throws Exception;
	
	public int status(UserVO userVO) throws Exception;
}
