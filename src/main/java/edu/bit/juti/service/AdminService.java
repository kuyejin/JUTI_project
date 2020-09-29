package edu.bit.juti.service;

import java.util.List;

import edu.bit.juti.vo.ProductVO;
import edu.bit.juti.vo.Product_CategoryVO;

public interface AdminService {
	
	List<ProductVO> productList() ;
	
	void productRegister(ProductVO productVO);
	
	List<Product_CategoryVO> category();

}
