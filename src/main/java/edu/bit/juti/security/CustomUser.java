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
	
	
	//����� ���� ��ȯ
	@Override 
	public Collection<GrantedAuthority> getAuthorities() {
		ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(user.getAuthorities()));
		return auth;
	}
	
	//����� ���̵� ��ȯ
	@Override
	public String getUsername() {
		return user.getUser_id();
	}

    //����� ��ȣ ��ȯ
	@Override
	public String getPassword() {
		return user.getUser_password();
	}

	
    //����� ���� ���Ῡ��
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	//����ڰ� ����ִ��� ����
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	//����� ��ȿ�� ����Ǿ����� ����
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//������� ��밡�� ����
	@Override
	public boolean isEnabled() {
		return true;
	}
	


}
