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
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Test1 {

	@Autowired
	private DataSource ds;

	/*
	 * @Test public void testConection()throws Exception{ try(Connection con =
	 * ds.getConnection()){ System.out.println(con);
	 * 
	 * }catch(Exception e){ e.printStackTrace(); } }
	 */

//	@Test
//	public void testConnection() {
//		try (Connection conn = ds.getConnection()) {
//			System.out.println("DB Connection Success" + conn);
//		} catch (Exception e) {
//			System.out.println("DB Connection fail");
//			e.printStackTrace();
//		}
//	}

	
	 @Test 
	 public void testDatasource() { 
		 log.info(ds); 
	 }
	




}
