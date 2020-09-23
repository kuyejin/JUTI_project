package edu.bit.juti.vo;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserVO {
	
	private String user_id;                  //¾ÆÀÌµð(pk)
	private String user_password;
	private String user_passwordCheck;
	private String user_name;
	private String user_birth;
	private String User_phonenumber;
	private String user_email;
	private String user_address;
	private int enabled;
	private String authority;
	private int logincheck;	
	
	



	
}
