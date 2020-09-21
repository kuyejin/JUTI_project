package edu.bit.juti.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.bit.juti.mapper.MemberMapper;
import edu.bit.juti.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Service
@Repository
public class MemberServiceImpl implements MemberService {
	
	private MemberMapper mapper;
	
	@Override
	public void addUser(UserVO userVO) {
		mapper.addUser(userVO);
	}
	
	
}