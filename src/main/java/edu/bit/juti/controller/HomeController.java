package edu.bit.juti.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

/**
 * Handles requests for the application home page.
 */
@Controller
@Log4j
@AllArgsConstructor
public class HomeController {
	

	
	@RequestMapping(value="/test")
	public String test() {
		log.info("test");
			
		return "1test";
	}
	
	@RequestMapping(value="/")
	public String main() {
		log.info("main");
			
		return "main";
	}
	
	
	@RequestMapping(value="/cart")
	public String cart() {
		log.info("cart");
			
		return "cart";
	}

	
	@RequestMapping(value="/mypage")
	public String mypage() {
		log.info("mypage");
			
		return "mypage";
	}
	
	@RequestMapping(value="/product")
	public String product() {
		log.info("product");
			
		return "product";
	}
	
	@RequestMapping(value="/order_product")
	public String order_product() {
		log.info("order_product");
			
		return "order_product";
	}
	
	@RequestMapping(value="/review")
	public String review() {
		log.info("review");
			
		return "review";
	}
	

	

}
