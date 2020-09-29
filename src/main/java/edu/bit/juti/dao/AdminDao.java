package edu.bit.juti.dao;


import java.util.List;

import edu.bit.juti.vo.LoginVO;
import edu.bit.juti.vo.ProductVO;
import edu.bit.juti.vo.Product_CategoryVO;
import edu.bit.juti.vo.UserVO;


public interface AdminDao {

	public List<ProductVO> productList();
	
	public void productRegister(ProductVO productVO);
	
	List<Product_CategoryVO> category();
	
}

	
	
	
	
	
	
	