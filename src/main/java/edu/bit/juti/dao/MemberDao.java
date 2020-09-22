package edu.bit.juti.dao;


import edu.bit.juti.vo.LoginVO;
import edu.bit.juti.vo.UserVO;


public interface MemberDao {

	
	void addUser_nomal(UserVO userVO); 
	
	UserVO login(LoginVO loginVO);

	
	
}

	
	
	
	
	
	
	