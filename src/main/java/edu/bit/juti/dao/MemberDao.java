package edu.bit.juti.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import edu.bit.juti.vo.LoginVO;
import edu.bit.juti.vo.UserVO;

@Repository
public interface MemberDao {

	
	void addUser_nomal(UserVO userVO); 
	
	UserVO login(LoginVO loginVO);
	
	UserVO loginCookie(LoginVO loginVO);

	
	/*
	 * //인증권한 void insertUser(UserVO userVO);
	 * 
	 * void insertAuthorities(UserVO userVO);
	 * 
	 * public List<UserVO> readUser(String id);
	 */
}

	
	
	
	
	
	
	