package edu.bit.juti.service;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.bit.juti.dao.MemberDao;
import edu.bit.juti.mapper.UserMapper;
import edu.bit.juti.vo.LoginVO;
import edu.bit.juti.vo.UserVO;

public class UserService {
	
			
	@Inject 
	private BCryptPasswordEncoder passEncoder; //암호화 시킬때 쓰는 클래스 -> 인코더와 디코더를 같이 해준다 
	
	@Inject 
	private UserMapper userMapper; 
	
	public void addUser(UserVO userVO){ 
		String password = userVO.getUser_password(); 
		String encode = passEncoder.encode(password); 
		
		userVO.setUser_password(encode); 
		
		userMapper.insertUser(userVO); 

		}


	
	

	
	
}
