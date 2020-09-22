package edu.bit.juti.mapper;


import java.sql.SQLException;

import org.apache.ibatis.annotations.Insert;

import edu.bit.juti.vo.UserVO;



public interface UserMapper {

	@Insert("insert into users(user_id,user_password,enabled,authority) values(#{user_id},#{user_password},#{enabled},'ROLE_USER')") 
	public int insertUser(UserVO userVO); 
	
	/*
	 * @Insert("insert into AUTHORITIES (username,AUTHORITY) values(#{username},'ROLE_USER')"
	 * ) public void insertAuthorities(UserVO UserVO);
	 */

	
	

	
	
}

	
	
	
	
	
	
	