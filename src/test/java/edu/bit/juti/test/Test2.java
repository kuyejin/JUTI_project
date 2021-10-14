package edu.bit.juti.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import edu.bit.juti.dao.MemberDao;
import edu.bit.juti.vo.UserVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@ContextConfiguration("file:src/main/resources/mybatis-config.xml")
@Log4j
public class Test2 {

	@Autowired
	private MemberDao memberdao;

	
	 @Test 
	 public void addUser_nomal() throws Exception{
	        
		 UserVO userVO = new UserVO();
	        
		 userVO.setUser_id("01");
		 userVO.setUser_password("123");
		 userVO.setUser_name("테스트 소개");
		 userVO.setUser_birth("123");
		 userVO.setUser_phonenumber("123");
		 userVO.setUser_email("테스트 소개");	           
		 userVO.setUser_address("테스트 소개");
	        
	        
		 memberdao.addUser_nomal(userVO);
	        
	    }    
	




}
