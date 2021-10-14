
package edu.bit.juti.security;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.bit.juti.dao.MemberDaoImpl;
import edu.bit.juti.mapper.UserMapper;
import edu.bit.juti.vo.UserVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

	
//	@Setter(onMethod_ =@Autowired)
//	private UserMapper userMapper;
	
	
	 @Autowired
	 private UserMapper userMapper;
	
		
	  @Override 
	  public UserDetails loadUserByUsername(String id) throws  UsernameNotFoundException { 
		  log.warn("유저아이디: " + id);
		  
		   UserVO vo = userMapper.readUser(id);
		   log.warn("queried by UserVO mapper: " + vo);
		  
		   return vo == null ? null : new CustomUser(vo); }
		 


	
}
