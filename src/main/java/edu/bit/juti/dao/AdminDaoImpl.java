package edu.bit.juti.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.bit.juti.vo.FileVO;
import edu.bit.juti.vo.LoginVO;
import edu.bit.juti.vo.ProductVO;
import edu.bit.juti.vo.Product_CategoryVO;
import edu.bit.juti.vo.UserVO;


@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	SqlSession sqlSession;

	//��ǰ���	
	@Override
	public List<ProductVO> productList() {		
		return sqlSession.selectList("admin.productList");
	}

	//��ǰ���
	@Override
	public void productRegister(ProductVO productVO) {
		sqlSession.insert("admin.productRegister", productVO);
		
	}
  
	//ī�װ� ����
	@Override
	public List<Product_CategoryVO> category() {		
		return sqlSession.selectList("admin.category");
	}

	
	
	
	
	
	
	
	@Override
	public int getProduct_id() {
		return sqlSession.selectOne("admin.getProduct_id");
	}

	@Override
	public void insertAttach(List<FileVO> list) {
		sqlSession.insert("BoardMapper.insertAttach",list);
		
	}
	
	
	
	


	
	
	

	
	
}

	
	
	
	
	
	
	