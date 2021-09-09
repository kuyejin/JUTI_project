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
		// rawPassword.toString()�� ��ȣȭ�� �Ƚ�Ű�ڴٴ� �� - �� �� �״��
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) { 
		log.warn("��й�ȣ ��Ī: " + rawPassword + ":" + encodedPassword);
		
		return rawPassword.toString().equals(encodedPassword);
		
		//�����ִ� �н����� ���ؼ� ���Ͻ��Ѷ�
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
//		log.warn("��й�ȣ ��Ī: " + rawPassword + ":" + encodedPassword);
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
