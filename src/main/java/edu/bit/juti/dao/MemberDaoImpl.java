package edu.bit.juti.dao;




import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.bit.juti.vo.LoginVO;
import edu.bit.juti.vo.UserVO;


@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSession sqlSession;

	//회원가입등록처리 - 일반
	@Override
	public void addUser_nomal(UserVO userVO) {
		sqlSession.insert("member.addUser_nomal", userVO);		
	}

	@Override
	public UserVO login(LoginVO loginVO) {
		return sqlSession.selectOne("member.login",loginVO);
	}

	
	
	

	
	
}

	
	
	
	
	
	
	