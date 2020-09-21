package edu.bit.juti.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import edu.bit.juti.vo.UserVO;


public interface LogInMapper { 
	
	@Select("select * from users where username = #{user_id} and password = #{user_password}")
	UserVO LogInUser(@Param("user_id") String user_id, @Param("user_password") String user_password);
}

	
	
	
	
	
	
	