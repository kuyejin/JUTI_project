package edu.bit.juti.security;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import edu.bit.juti.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Getter
@Setter
public class CustomUser extends User implements UserDetails{
	
	private UserVO user;
	

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}
	
	
	public CustomUser(UserVO userVO) {			
		super(userVO.getUser_id(), userVO.getUser_password(),
			  Collections.singletonList(new SimpleGrantedAuthority(userVO.getAuthorities())));
		this.user = userVO;
	}	
	
	
	//사용자 권한 반환
	@Override 
	public Collection<GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(user.getAuthorities()));
		return auth;
	}
	
	//사용자 아이디 반환
	@Override
	public String getUsername() {
		return user.getUser_id();
	}

    //사용자 암호 반환
	@Override
	public String getPassword() {
		return user.getUser_password();
	}

	
    //사용자 계정 만료여부
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//사용자가 잠겨있는지 여부
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//사용자 암효가 만료되었는지 여부
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//사용자의 사용가능 여부
	@Override
	public boolean isEnabled() {
		return true;
	}
	


}
