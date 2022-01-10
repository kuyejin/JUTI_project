package edu.bit.juti.service;

import java.sql.SQLException;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import edu.bit.juti.dao.MemberDao;
import edu.bit.juti.vo.LoginVO;
import edu.bit.juti.vo.UserVO;

@Service
public interface MemberService {
	
			
	void addUser(Model model, UserVO userVO);
	
	UserVO login(HttpServletRequest req, HttpServletResponse resp, LoginVO loginVo);

	UserVO loginCookie(HttpServletRequest req, HttpServletResponse resp, LoginVO loginVO);
	
	void logout(HttpServletRequest req, HttpServletResponse resp);
	
	
}
