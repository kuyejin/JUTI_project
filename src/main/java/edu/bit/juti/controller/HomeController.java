package edu.bit.juti.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	
	@GetMapping("/test") 
	public String test() {
		log.info("test");
			
		return "test";
	}
	
	@GetMapping("/") 
	public String main() {
		log.info("main");
			
		return "main";
	}
	
	
	
	
	@GetMapping("/cart") 
	public String cart() {
		log.info("cart");
			
		return "cart";
	}
	
	@GetMapping("/mypage") 
	public String mypage() {
		log.info("mypage");
			
		return "mypage";
	}
	
	@GetMapping("/product") 
	public String product() {
		log.info("product");
			
		return "product";
	}
	
	@GetMapping("/order_product") 
	public String order_product() {
		log.info("order_product");
			
		return "order_product";
	}
	
	@GetMapping("/review") 
	public String review() {
		log.info("review");
			
		return "review";
	}
	
	
	
	
}
