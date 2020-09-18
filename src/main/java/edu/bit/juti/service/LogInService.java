package edu.bit.juti.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.bit.juti.mapper.LogInMapper;

import edu.bit.juti.vo.UserVO;
import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class LogInService {
	LogInMapper logInMapper;
	
	public UserVO loginUser(String id, String pw) {
		return logInMapper.LogInUser(id, pw);
	}
	
}
