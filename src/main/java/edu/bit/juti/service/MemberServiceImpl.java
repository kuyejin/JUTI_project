package edu.bit.juti.service;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
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


@Log4j
@AllArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {

	 
	 @Inject 
	 MemberDaoImpl memberDao;
	 



	
	//회원가입 등록처리
	@Override
	public void addUser(Model model, UserVO userVO) {
				
		memberDao.addUser_nomal(userVO);
		/*
		 * userVO = memberDao.find_pronum(userVO); 
		 * memberDao.myadminInsert(userVO);
		 */
		model.addAttribute("join",userVO);
	}

	@Override
	public UserVO login(HttpServletRequest req, HttpServletResponse resp, LoginVO loginVO) {
		UserVO user = memberDao.login(loginVO);
				
		return user;
	}


	
		
		
	
	
	  
	  
	 
}

