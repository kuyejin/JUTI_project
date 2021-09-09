package edu.bit.juti.dao;


import java.util.List;

import edu.bit.juti.vo.FileVO;
import edu.bit.juti.vo.LoginVO;
import edu.bit.juti.vo.ProductVO;
import edu.bit.juti.vo.Product_CategoryVO;
import edu.bit.juti.vo.UserVO;


public interface AdminDao {

	List<ProductVO> productList();
	
	void productRegister(ProductVO productVO);
	
	List<Product_CategoryVO> category();
	
	int getProduct_id(); 
	
	void insertAttach(List<FileVO> list) ;
	
	
	
	
	
	
	
}

	
	
	
	
	
	
	