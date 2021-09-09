package edu.bit.juti.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.bit.juti.vo.ProductVO;
import edu.bit.juti.vo.Product_CategoryVO;

public interface AdminService {
	
	List<ProductVO> productList() ;
	
	
	
	
	
	void productRegister(ProductVO productVO);
	
	ProductVO productRegister(HttpServletRequest req, MultipartFile[] files, ProductVO productVO);
	
	
	
//	void productRegister(ProductVO productVO, MultipartFile[] uploadFile) ;
	

	
	
	
	
	List<Product_CategoryVO> category();




//	ProductVO productRegister(MultipartHttpServletRequest req, MultipartFile[] uploadFile, ProductVO productVO);
//	ProductVO productRegister(MultipartHttpServletRequest req, MultipartFile uploadFile, ProductVO productVO);

}
