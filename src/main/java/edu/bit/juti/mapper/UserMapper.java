package edu.bit.juti.mapper;


import java.sql.SQLException;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import edu.bit.juti.vo.UserVO;



public interface UserMapper {

	/*
	 * @Insert("insert into USERS(user_id, user_password, enabled) " +
	 * "values(#{user_id},#{user_password},#{enabled})") public int
	 * insertUser(UserVO userVO);
	 */

	@Insert("insert into AUTHORITIES (user_id, authority) values(#{user_id},'ROLE_USER')")
	public void insertAuthorities(UserVO UserVO);
		
	@Select("select * from USERS where user_id = #{id}")
	 public UserVO readUser(String id);
	
	//@Select("select * from USERS where user_id = #{id}")
	// public CustomUserDetails readUser(String id);

	
	
}

	
	
	
	
	
	
	