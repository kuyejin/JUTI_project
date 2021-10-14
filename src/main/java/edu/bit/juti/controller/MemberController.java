package edu.bit.juti.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import edu.bit.juti.service.MemberService;
import edu.bit.juti.service.MemberServiceImpl;
import edu.bit.juti.vo.LoginVO;
import edu.bit.juti.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/member/")
@Log4j
public class MemberController {

    		
	@Autowired
	private MemberServiceImpl memberService;
	

	
	// �α��� ȭ�� (�˾�)
	@RequestMapping(value = "loginForm")
    public String login(HttpSession session) throws Exception{
		log.info("/login");				
		return "member/loginForm";			
    }
	
	// �α��� ó��
	/*
	 * @RequestMapping(value = "login", method = RequestMethod.POST)
	 * public @ResponseBody UserVO login(HttpServletRequest req, HttpServletResponse
	 * resp,LoginVO loginVO) { UserVO user = memberService.login(req, resp,loginVO);
	 * return user; }
	 */
	
	// �α׾ƿ� (�˾�)
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout() {
		return "member/logout";
	}
	
	
	
	//ȸ������
	@RequestMapping(value="join")
	public String join() {
		log.info("join");			
		return "member/join";
	}
									
	
	
	//ȸ�����Լ���
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public String addUser(Model model, UserVO userVO) {
		System.out.println(userVO);
		memberService.addUser(model, userVO);					
		
		return "member/success"; 
		
	}
	
	//@ó���ؾߵ� �α�������
	@RequestMapping(value = "loginCookie", method = RequestMethod.POST)
	public @ResponseBody UserVO loginCookie(HttpServletRequest req, HttpServletResponse resp, LoginVO loginVO) {
		
		return memberService.loginCookie(req, resp, loginVO);
	}

	 //@ó���ؾߵ� ����üũ
	@RequestMapping(value = "loginSession", method = RequestMethod.POST)
	public @ResponseBody UserVO  loginSession(HttpServletRequest req,HttpSession session) {
	         
	   return (UserVO ) session.getAttribute("login");
	}

		
		
	
	

	
			
	

	
	
	

	
	
	
	
	
}	
	

