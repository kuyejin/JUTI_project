package edu.bit.juti.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.bit.juti.vo.LoginVO;
import edu.bit.juti.vo.UserVO;


@Repository
public class MemberDaoImpl implements MemberDao{

	@Autowired
	SqlSession sqlSession;

	//ȸ�����Ե��ó�� - �Ϲ�
	@Override
	public void addUser_nomal(UserVO userVO) {
		sqlSession.insert("member.addUser_nomal", userVO);		
	}

	//�α���ó�� �� �ش� ȸ���������
	@Override
	public UserVO login(LoginVO loginVO) {
		return sqlSession.selectOne("member.login",loginVO);
	}
    
	
	@Override
	public UserVO loginCookie(LoginVO loginVO) {

		return sqlSession.selectOne("member.loginCookie", loginVO);
	}
	
	
	
	//��������
	/*
	 * @Override public void insertUser(UserVO userVO) {
	 * sqlSession.insert("member.insertUser", userVO);
	 * 
	 * }
	 * 
	 * @Override public void insertAuthorities(UserVO userVO) {
	 * sqlSession.insert("member.insertAuthorities", userVO);
	 * 
	 * }
	 * 
	 * @Override public UserVO readUser(String id) {
	 * 
	 * return sqlSession.selectList("member.readUser", id); }
	 */

	
	
	

	
	
}

	
	
	
	
	
	
	