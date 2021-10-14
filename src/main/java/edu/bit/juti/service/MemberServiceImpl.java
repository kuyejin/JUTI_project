package edu.bit.juti.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


import edu.bit.juti.dao.MemberDao;
import edu.bit.juti.dao.MemberDaoImpl;
import edu.bit.juti.mapper.UserMapper;
import edu.bit.juti.vo.LoginVO;
import edu.bit.juti.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {

	 
	@Autowired 
	 MemberDaoImpl memberDao;
	 
	@Autowired
	 UserMapper userMapper;
	 
	@Autowired
	private BCryptPasswordEncoder passEncoder;

	
	//회원가입 등록처리
	@Override
	public void addUser(Model model, UserVO userVO) {
			 	
		userVO.setUser_password(passEncoder.encode(userVO.getUser_password()));	
//		String encode = passEncoder.encode(password);
//		String password = userVO.getUser_password();
		
		memberDao.addUser_nomal(userVO);
		
		userMapper.insertAuthorities(userVO);
		
		model.addAttribute("user",userVO);
	}
	

	//로그인 처리
	@Override
	public UserVO login(HttpServletRequest req, HttpServletResponse resp, LoginVO loginVO) {
		UserVO user = memberDao.login(loginVO);
		
		HttpSession session = req.getSession();
		session.setAttribute("login", user);

		return user;
	}

	//로그인 유지
	@Override
	public UserVO loginCookie(HttpServletRequest req, HttpServletResponse resp, LoginVO loginVO) {
		UserVO user = memberDao.loginCookie(loginVO);
		loginVO.setPw(user.getUser_password());
		
		user = memberDao.login(loginVO);
		System.out.println(user);

		HttpSession session = req.getSession();
		session.setAttribute("login", user);


		return user;
	}

    //로그아웃
	@Override
	public void logout(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.invalidate();
		Cookie[] userCookies = req.getCookies();
	    for(int i=0; i<userCookies.length; i++) {
	         userCookies[i].setMaxAge(0);
	         userCookies[i].setPath("/");
	         resp.addCookie(userCookies[i]);
	    }
		
	}

	
		
		
	
	
	  
	  
	 
}

