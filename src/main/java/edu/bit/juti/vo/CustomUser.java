package edu.bit.juti.vo;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
public class CustomUser extends User {
	
	private UserVO user;
	

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	public CustomUser(UserVO userVO) {	
		
		super(userVO.getUser_id(), userVO.getUser_password(),
			  Collections.singletonList(new SimpleGrantedAuthority(userVO.getAuthority())));

		this.user = userVO;
	}	
}
