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
	
	String user_id;                  //¾ÆÀÌµð(pk)
	String user_password;
	String user_passwordCheck;
	String user_name;
	String user_birth;
	String User_phonenumber;
	String user_email;
	String user_address;
	int enabled;
	
	



	
}
