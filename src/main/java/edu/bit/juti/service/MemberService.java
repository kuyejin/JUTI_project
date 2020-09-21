package edu.bit.juti.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.bit.juti.mapper.LogInMapper;

import edu.bit.juti.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

public interface MemberService {
	
	
	/*@Inject
	private BCryptPasswordEncoder passEncoder;*/
	
	/*
	 * @Inject private static UserMapper userMapper;
	 */
	/*
	 * public static void addUser(UserVO userVO) { String user_id =
	 * userVO.getUser_id(); String user_password = userVO.getUser_password(); String
	 * user_passwordCheck = userVO.getUser_passwordCheck(); String user_name =
	 * userVO.getUser_name(); Date user_birth = userVO.getUser_birth(); String
	 * user_phoneNumber = userVO.getUser_phonenumber(); String user_email =
	 * userVO.getUser_email(); String user_address = userVO.getUser_address();
	 * 
	 * //String encode = passEncoder.encode(password);
	 * 
	 * //userVO.setPassword(encode);
	 * 
	 * userMapper.insertUser(userVO); userMapper.insertAuthorities(userVO);
	 * 
	 * }
	 */
	
	public void addUser(UserVO userVO); 
	
}
