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

import edu.bit.juti.dao.AdminDao;
import edu.bit.juti.dao.MemberDao;
import edu.bit.juti.vo.ProductVO;
import edu.bit.juti.vo.UserVO;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@ContextConfiguration("file:src/main/resources/mybatis-config.xml")
@Log4j
public class Test3 {

	@Autowired
	private AdminDao admindao;

	
	 @Test 
	 public void roductRegister() throws Exception{
	        
		 ProductVO productVO = new ProductVO();
	        
		 productVO.setProduct_id(01);
		 productVO.setProduct_name("123");
		 productVO.setProduct_price(4);
		 productVO.setProduct_image("123");
		 productVO.setCategory_id(123);
		 productVO.setProduct_stock(1);	           
		 productVO.setProduct_date(null);
	        
		
		 admindao.productRegister(productVO);
	        
	    }    
	




}
