package edu.bit.juti.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.log4j.Log4j;

@Log4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder {
	
	
	@Override
	public String encode(CharSequence rawPassword) { 
		log.warn("before encode :" + rawPassword);
		return rawPassword.toString(); 		
		// rawPassword.toString()는 암호화을 안시키겠다는 것 - 날 것 그대로
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) { 
		log.warn("비밀번호 매칭: " + rawPassword + ":" + encodedPassword);
		
		return rawPassword.toString().equals(encodedPassword);
		
		//원래있던 패스워드 비교해서 리턴시켜라
	}
	
//	private PasswordEncoder passwordEncoder; 	
//	public String encode(CharSequence rawPassword) {
//		log.warn("before encode :" + rawPassword);
//		 String salt = BCrypt.gensalt();
//       
//        return BCrypt.hashpw(rawPassword.toString(), salt);
//    }
//	
//	public boolean matches(CharSequence rawPassword, String encodedPassword) {
//		log.warn("비밀번호 매칭: " + rawPassword + ":" + encodedPassword);
//		if (rawPassword == null) {
//			throw new IllegalArgumentException("rawPassword cannot be null");
//		}
//
//		if (encodedPassword == null || encodedPassword.length() == 0) {
//			log.warn("Empty encoded password");
//			return false;
//		}
//		
//		return BCrypt.checkpw(rawPassword.toString(), encodedPassword);
//		
//	}



}
