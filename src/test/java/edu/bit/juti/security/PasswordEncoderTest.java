//package edu.bit.juti.security;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.junit.Assert.assertThat;
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import lombok.extern.log4j.Log4j;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration 
//public class PasswordEncoderTest  {
//	@Test
//	public void passwordEncoding() {
//
//		BCryptPasswordEncoder pwEncoder = 
//				(BCryptPasswordEncoder) ctx.getBean("passwordEncoder");
//
//		String pw = "codevang";
//		String encodedPw1 = pwEncoder.encode(pw);
//		String encodedPw2 = pwEncoder.encode(pw);
//
//		System.out.println("���� : " + pw);
//		System.out.println("ù�� ° ���ڵ� : " + encodedPw1);
//		System.out.println("�ι� ° ���ڵ� : " + encodedPw2);
//
//		System.out.println("�ܼ� ���ڿ� �� : "
//				+ encodedPw1.equals(pwEncoder.encode("codevang")));
//	}
//	
//	@Autowired
//    private PasswordEncoder passwordEncoder;
// 
//    @Test
//    public void test() {
//        String rawPassword = "password";
//        String encodedPassword = passwordEncoder.encode(rawPassword);
//        assertThat(passwordEncoder.matches(rawPassword, encodedPassword), is(true));
//    }
//    
//    @Test
//	public void testBCrypt() {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String result = encoder.encode("ram123");
//		assertTrue(encoder.matches("ram123", result));		
//	}
//}
