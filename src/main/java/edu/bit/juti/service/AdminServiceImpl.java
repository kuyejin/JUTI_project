package edu.bit.juti.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import edu.bit.juti.dao.AdminDao;
import edu.bit.juti.dao.AdminDaoImpl;
import edu.bit.juti.dao.MemberDaoImpl;
import edu.bit.juti.mapper.UserMapper;
import edu.bit.juti.util.UtilFile;
import edu.bit.juti.vo.FileVO;
import edu.bit.juti.vo.ProductVO;
import edu.bit.juti.vo.Product_CategoryVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService{
	
	@Inject 
	 AdminDaoImpl adminDao;
	

	
    //��ǰ���
	@Override
	public List<ProductVO> productList() {
		System.out.println("��ǰ����Ʈ");
		return adminDao.productList();
	}

	//��ǰ���
	@Override	
	public void productRegister(ProductVO productVO) {		
		adminDao.productRegister(productVO);		
	}
	
	@Override
	public ProductVO productRegister(HttpServletRequest req, MultipartFile[] files, ProductVO productVO) {
		edu.bit.juti.util.UploadPhoto up = new edu.bit.juti.util.UploadPhoto();	    
//	    if(files != null) {
//	         String product_image = up.upload(files, req, productVO);
//	         productVO.setProduct_image(product_image);
//	      }else if(productVO.getProduct_image().equals("undefined")) {
//	    	  productVO.setProduct_image(null);
//	      }
	    
	    String product_image = up.upload(files, req, productVO);
        productVO.setProduct_image(product_image);
	    
	    adminDao.productRegister(productVO);	
	    
	    HttpSession session = req.getSession();
	    session.setAttribute("profile", productVO);
	    
	    return productVO;
	    
	 
	}
	
//	 @Override
//	 public ProductVO productRegister(MultipartHttpServletRequest req, MultipartFile uploadFile, ProductVO productVO) {
////	   public ProductVO productRegister(MultipartHttpServletRequest req, MultipartFile[] files, ProductVO productVO) {
////	      edu.bit.juti.util.UploadPhoto up = new edu.bit.juti.util.UploadPhoto();
////	      String product_image = up.upload(files, req, productVO);
//		 UtilFile utilFile = new UtilFile();
//		String product_image=utilFile.fileUpload(req,uploadFile,productVO);
//		 
//	      productVO.setProduct_image(product_image);
//
//	     // HttpSession session = req.getSession();
//
////	      ProfileVo profile = (ProfileVo) session.getAttribute("profile");
////	      int ventureCheck = (int) session.getAttribute("ventureCheck");
////	      
////	      if(ventureCheck ==0) {
////	         adminDao.groupInsert(groupVo);
////	      }
////	      else {
////	         userDao.groupVentureInsert(groupVo);
////	      }
////	      groupVo = userDao.groupmyGroup(profile);
////	      userDao.myGroupJoin(groupVo);
////	      List<JoinGroupVo> joinGroup = memberDao.myJoinGroupSelectAll(profile);
//	      
////	      session.setAttribute("joinGroup", joinGroup);
//	      
//	      adminDao.productRegister(productVO);
////	      session.setAttribute("product", productVO);
////	      session.setAttribute("groupCheck", 1);
////	      req.setAttribute("detail", productVO);
//
//	      return productVO;
//	   }
	
	
	
//	@Transactional
//	@Override
//	public void productRegister(ProductVO productVO, MultipartFile[] uploadFile) {
//		List<FileVO> list = new ArrayList<>();
//		
//		//������ ������ ��� ����
//		String path = getPath();
//		
//		//ex) D:\\upload\\2019\\06\\21
//		File uploadPath = new File("C:"+File.separator+"upload"+File.separator+path);
//		
//		//������ ���ٸ� ����
//		if (uploadPath.exists() == false) {
//			uploadPath.mkdirs();
//		}
//		
//		//�Խñ� ��� ����
//		adminDao.productRegister(productVO);
//		
//		//�Խ��� �� ��ȣ ������
//		int product_id = adminDao.getProduct_id();
//		//������ ������ ������
//		if(!uploadFile[0].getOriginalFilename().equals("")) {
//			for(MultipartFile file : uploadFile) {
//				FileVO fileVO = new FileVO();
//				String fileName = file.getOriginalFilename();
//				
//				//���ϸ� ����
//				fileName = fileName.substring(fileName.lastIndexOf(File.separator)+1);
//				//Ȯ���� ����
//				String ext=fileName.substring(fileName.lastIndexOf("."));
//				//uuid ���� 
//				String uuid= UUID.randomUUID().toString();
//				
//				//���ϸ��� UUID+Ȯ���ڷ� ������ ����
//				File saveFile = new File(uploadPath,uuid+ext);
//				
//				//vo ����
//				fileVO.setProduct_id(product_id);
//				fileVO.setFile_Name(fileName);
//				fileVO.setPath(path);
//				fileVO.setUuid(uuid+ext);
//				
//				
//				//���� ����
//				try {
//					file.transferTo(saveFile);
//				} catch (IllegalStateException e) {					
//					e.printStackTrace();
//				} catch (IOException e) {					
//					e.printStackTrace();
//				}
//				list.add(fileVO); //����Ʈ�� �߰�												
//			}
//		
//			//���� ��� �߰�
//			adminDao.insertAttach(list);	
//		}
//	}
//    		
//		private String getPath() {
//	
//			//��¥�� ��-��-�Ϸ� ����
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//			Date date = new Date();
//			String str = sdf.format(date);
//			//ex) 2019\\06\\21
//			String path = str.replace("-",File.separator);
//			
//			return path;
//		}
		
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public List<Product_CategoryVO> category() {
		return adminDao.category();
	}


}