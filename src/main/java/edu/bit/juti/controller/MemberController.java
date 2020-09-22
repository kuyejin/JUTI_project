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


import edu.bit.juti.service.LogInService;
import edu.bit.juti.service.MemberService;
import edu.bit.juti.service.MemberServiceImpl;
import edu.bit.juti.vo.LoginVO;
import edu.bit.juti.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
public class MemberController {
	
	
	@Autowired
	private LogInService loginService;
	
	
	@Inject
	private MemberServiceImpl memberService;

	
	//처리해야함
	@RequestMapping(value = "/login2", method = RequestMethod.GET)
	public String login(HttpServletRequest req, RedirectAttributes rttr) throws Exception{
		
		log.info("post login");
		
		//Session 처리를 위한 Session객체 HttpServletRequest안에 있음
		HttpSession session = req.getSession();
		
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_password");
		
		UserVO login = loginService.loginUser(id,pw);
		
		if(login == null) {
			session.setAttribute("user", null);
			
			//spring3에서 제공하는 RedirectAttributes를 사용하면 redirect post 구현이 가능합니다
			//하지만 일회성입니다. 새로고침하면 날라가는 데이터이므로 사용목적에 따라서 사용/불가능 판단을 잘 하셔야 합니다
			
			rttr.addFlashAttribute("msg",false); //리다이렉트 직전 플래시에 저장하는 메소드다. 리다이렉트 이후에는 소멸한다.

		}else {
			session.setAttribute("user",login);
		}
		//return "redirect:/";
		return "login2";
		
	}
	
	// 로그인 화면 (팝업)
	@RequestMapping(value = "login")
    public String login(HttpSession session) throws Exception{
		log.info("/login");
				
		return "member/login";			
    }
	
	// 로그인 처리
	@RequestMapping(value = "login", method = RequestMethod.POST)
		public @ResponseBody UserVO login(HttpServletRequest req, HttpServletResponse resp,LoginVO loginVo) {
			UserVO user = memberService.login(req, resp,loginVo);
			
			return user;
		}
	
	//로그인 정보를 왜 session에 넣는지?
		//session객체는  HttpSession에서 받아온다
		
		@RequestMapping(value = "/logout")
	        public String logout(HttpSession session) throws Exception{
				log.info("/member/logout");
				
				session.invalidate(); //메모리에서 유저날리는 것 - 왜 DELETE가 아닌가? 가비지컬렉터가 유저정보를 지우는 데 정보가 완전히 지워지지는 않는다. ->메모리에 남아있음
				                      //                                 .invalidate는 가비지컬렉터에게 메모리 지우는 대상이라고 알려주는것
				
				return "redirect:/";
						
		}
		
		
		
		
		
		//회원가입
		@RequestMapping(value = "/join")
		public String join() { 
			log.info("join");
			
			return "member/join"; 
		}
					
		//회원가입성공
		@RequestMapping(value = "/member/addUser", method = RequestMethod.POST)
		public String addUser(Model model, UserVO userVO) {
			System.out.println(userVO);
			memberService.addUser(model, userVO);
						
			return "member/success";
		}

		
		
	
	

	
			
	

	
	
	

	
	
	
	
	
}	
	

