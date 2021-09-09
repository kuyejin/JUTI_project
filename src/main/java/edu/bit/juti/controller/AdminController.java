package edu.bit.juti.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import edu.bit.juti.service.AdminServiceImpl;
import edu.bit.juti.service.MemberService;
import edu.bit.juti.service.MemberServiceImpl;

import edu.bit.juti.util.UtilFile;

import edu.bit.juti.vo.FileVO;
import edu.bit.juti.vo.LoginVO;
import edu.bit.juti.vo.ProductVO;
import edu.bit.juti.vo.Product_CategoryVO;
import edu.bit.juti.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import net.sf.json.JSONArray;

@Controller
@RequestMapping("/admin/")
@Log4j
public class AdminController {

    		
	@Inject
	private AdminServiceImpl adminService;
	
	//관리자페이지
	@RequestMapping(value = "index")
    public String index(){
		log.info("index");				
		return "admin/index";			
    }
	
	//상품목록
	@RequestMapping(value = "proList")
    public String productlist(Model model){
		log.info("상품목록");				
		return "admin/proList";			
    }
	
	//상품목록 완료
	@RequestMapping(value = "proList", method = RequestMethod.GET)
    public void prolist(Model model){
		log.info("상품목록");			
		List<ProductVO> prolist = adminService.productList();
		model.addAttribute("prolist",prolist);					
    }

	
	
	
	
	
	

//	//상품등록 페이지
//	@RequestMapping(value = "proRegister")
//    public String productRegister(){
//		log.info("상품등록");
//				
//		return "admin/proRegister";			
//    }
//	
//	
//	
//	// 상품카테고리 등록///////////////////
//	@RequestMapping(value = "proRegister", method = RequestMethod.GET)
//	public void productRegister(Model model) throws Exception {
//	 log.info("카테고리");
//	 
////	 List<Product_CategoryVO> category = null;
//	 List<Product_CategoryVO> category = adminService.category();
//	 model.addAttribute("category", category);
//	}
	
	
	
	//상품등록 페이지
	@RequestMapping(value = "proRegister")
    public String productRegister(Model model){
		log.info("상품등록");
		
		 List<Product_CategoryVO> category = adminService.category();
		 model.addAttribute("category", category);
				
		return "admin/proRegister";			
    }
	
	
	//상품등록 완료
//	@RequestMapping(value = "addProRegister", method = RequestMethod.POST)
//	public String reAddProCtrl(MultipartHttpServletRequest req, @RequestParam("uploadFile") MultipartFile uploadFile,  ProductVO productVO) {		
//		
//		adminService.productRegister(productVO);
//
//	    return "redirect:/admin/proList";
//	 }
	
		
	
	//상품등록 완료
//	@RequestMapping(value = "addProRegister", method = RequestMethod.POST)
//    public String addProductRegister(ProductVO productVO){
//		log.info("상품등록완료");
		
//		adminService.productRegister(productVO);
			
//		return "redirect:/admin/proList";			
//   }
	
	//상품등록 완료
	@RequestMapping(value = "addProRegister", method = RequestMethod.POST)
	public String addProductRegister(HttpServletRequest req, MultipartFile[] files, ProductVO productVO){
		productVO = adminService.productRegister(req, files, productVO);
		
        System.out.println(files.toString());
			
		return "redirect:/admin/proList";			
  }
	
//	//상품등록 완료
//	@RequestMapping(value = "addProRegister", method = RequestMethod.POST)
//	public String uploadFile(MultipartFile[] files, HttpServletRequest request) { 
//		
//		//파일이 업로드 될 경로 설정 
//		String saveDir = request.getSession().getServletContext().getRealPath("/resources/upload"); 
//		
//		//위에서 설정한 경로의 폴더가 없을 경우 생성		
//		File dir = new File(saveDir); 
//		if(!dir.exists()) { 
//			dir.mkdirs(); 
//		} 
//		
//		// 파일 업로드 
//		for(MultipartFile f : files) { 
//			if(!f.isEmpty()) { 
//			
//			// 기존 파일 이름을 받고 확장자 저장
//			String orifileName = f.getOriginalFilename(); 
//			String ext = orifileName.substring(orifileName.lastIndexOf(".")); 
//			
//			// 이름 값 변경을 위한 설정
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmssSSS"); 			
//			int rand = (int)(Math.random()*1000); 
//			
//			// 파일 이름 변경 
//			String reName = sdf.format(System.currentTimeMillis()) + "_" + rand + ext; 
//			
//			// 파일 저장
//			try { 
//				f.transferTo(new File(saveDir + "/" + reName)); 
//			}catch (IllegalStateException | IOException e) { 
//					e.printStackTrace(); 
//			} 
//			} 
//		} 
//		return "redirect:/admin/proList"; 
//	} 
	
	
	
	

   




	
	
	
	
	
	
	
	
	
	

	
	
	



	
		
	
	

	
			
	

	
	
	

	
	
	
	
	
}	
	

