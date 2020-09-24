
package edu.bit.juti.security;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.bit.juti.dao.MemberDaoImpl;
import edu.bit.juti.mapper.UserMapper;
import edu.bit.juti.vo.CustomUser;

import edu.bit.juti.vo.UserVO;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class CustomUserDetailsService implements UserDetailsService {


	/*
	 * @Inject private UserMapper userMapper;
	 */
	
	@Inject 
	 private UserMapper usermapper;
	
		
	  @Override 
	  public UserDetails loadUserByUsername(String id) throws  UsernameNotFoundException { 
		  log.warn("Load User By User number: " + id);
		  
		   UserVO vo = usermapper.readUser(id);
		   log.warn("queried by UserVO mapper: " + vo);
		  
		   return vo == null ? null : new CustomUser(vo); }
		 
	/*
	 @Override
	    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
	        CustomUserDetails user =usermapper.readUser(id);
	        if(user==null) {
	            throw new UsernameNotFoundException(id);
	        }
	        return user;
	    }
	 */


	
}
